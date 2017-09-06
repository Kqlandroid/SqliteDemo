package com.demos.tags;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.demos.tags.utile.utils.PixelUtil;

import java.io.File;


public class VidoPlayerActivity extends AppCompatActivity {
    private static final String TAG = "VidoPlayerActivity";
    private static final int UPDATE_UI = 1;
    private int sereen_weith ;
    private int sereen_height;
    private boolean isAdjust = false;
    private int thshold = 54;
    private boolean iSFullScreen=false;
    private float lastX=0;
    private float lastY=0;
    private float mBrightness;
    private AudioManager mAudiomanager;
    private CustomVideoView videoView;
    private ImageView play_controller_img;
    private TextView timeCurrentTv;
    private TextView timeTotalTv;
    private LinearLayout leftLayout;
    private ImageView screenImg;
    private LinearLayout cotrollbarLayout;
    private SeekBar playerSeekbar;
    private SeekBar volumeSeekbar;
    private RelativeLayout video_layout;
    private ImageView volume_img;
    private ImageView operation_bg,operation_percent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vido_player);
        mAudiomanager=(AudioManager)getSystemService(AUDIO_SERVICE);
        initUI();

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/GoingHome.mp4";
        Log.i(TAG, "onCreate: " + path);
        File f = new File(path);
        if (f.length() > 0) {
            Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "1234", Toast.LENGTH_SHORT).show();
        }

        //本地视频播放
        videoView.setVideoPath(path);

        //网络视频播放
//        videoView.setVideoURI(Uri.parse("http://v.yinyuetai.com/video/96473"));
        //使用MEdiaController控制播放
        videoView.start();
        UIHndler.sendEmptyMessage(UPDATE_UI);
//        MediaController controller = new MediaController(this);
//        //设置VideoVew与MediaController建立关联
//        videoView.setMediaController(controller);
//        controller.setMediaPlayer(videoView);
        setPlayerEvent();
        getSDPath();
    }

    private void initUI() {
        PixelUtil.initPixelUtil(this);
        videoView = (CustomVideoView) findViewById(R.id.videoView);
        play_controller_img = (ImageView) findViewById(R.id.pause_img);
        timeCurrentTv = (TextView) findViewById(R.id.time_current_tv);
        timeTotalTv = (TextView) findViewById(R.id.time_total_tv);
        leftLayout = (LinearLayout) findViewById(R.id.left_layout);
        screenImg = (ImageView) findViewById(R.id.screen_img);
        cotrollbarLayout = (LinearLayout) findViewById(R.id.cotrollbar_layout);
        playerSeekbar  = (SeekBar) findViewById(R.id.player_seekbar);
        volumeSeekbar = (SeekBar) findViewById(R.id.volume_seekbar);
        video_layout = (RelativeLayout) findViewById(R.id.video_layout);
        volume_img = (ImageView) findViewById(R.id.volume_img);
        sereen_weith = getResources().getDisplayMetrics().widthPixels;
        sereen_height = getResources().getDisplayMetrics().heightPixels;
        operation_bg = (ImageView) findViewById(R.id.progress_bg);
        operation_percent= (ImageView) findViewById(R.id.operation_percent);
        progress_layout=(FrameLayout)findViewById(R.id.progress_layout);
        int streamMaxVolumd = mAudiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int streamVoludm = mAudiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volumeSeekbar.setMax(streamMaxVolumd);
        volumeSeekbar.setProgress(streamVoludm);
    }
    private void setVideoViewScale(int width,int height){
        ViewGroup.LayoutParams l=videoView.getLayoutParams();
        l.width=width;
        l.height=height;
        videoView.setLayoutParams(l);
        ViewGroup.LayoutParams l2=video_layout.getLayoutParams();
        l2.width=width;
        l2.height=height;
        video_layout.setLayoutParams(l2);
    }
    /**
     * 监听屏幕方向改变
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //当屏幕方向为横屏的时候
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
            volume_img.setVisibility(View.VISIBLE);
            volumeSeekbar.setVisibility(View.VISIBLE);
            iSFullScreen=true;
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        //屏幕方向为竖屏
        else {
            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, PixelUtil.dp2px(this,240));
            volume_img.setVisibility(View.GONE);
            volumeSeekbar.setVisibility(View.GONE);
            iSFullScreen=false;
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }
    }

    private void updateTextViewWithTimeFormat(TextView tv, int millissecond) {
        int second = millissecond/1000;
        int hh = second/3600;
        int mm = second%3600/60;
        int ss = second%60;
        String str = null;
        if (hh!=0){
            str = String.format("%02d:%02d:%02d:",hh,mm,ss);
        }else {
            str = String.format("%02d:%02d",mm,ss);
        }
        tv.setText(str);
    }


    private Handler UIHndler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == UPDATE_UI) {
                //获取视频正在播放时间
                int currentPosition = videoView.getCurrentPosition();
                //获取视频播放的总时间
                int totaldurtion = videoView.getDuration();
                //格式化视频播放时间
                updateTextViewWithTimeFormat(timeCurrentTv, currentPosition);
                updateTextViewWithTimeFormat(timeTotalTv, totaldurtion);
                playerSeekbar.setMax(totaldurtion);
                playerSeekbar.setProgress(currentPosition);
                UIHndler.sendEmptyMessageDelayed(UPDATE_UI, 500);
            }
        }
    };
    private void setPlayerEvent() {
        //控制视频的播放和暂停
        play_controller_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (videoView.isPlaying()){
                    play_controller_img.setImageResource(R.drawable.play_btn_style);
                    videoView.pause();
                    UIHndler.removeMessages(UPDATE_UI);
                }else {
                    play_controller_img.setImageResource(R.drawable.pause_btn_style);
                    videoView.start();
                    UIHndler.sendEmptyMessage(UPDATE_UI);
                }
            }
        });
        playerSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTextViewWithTimeFormat(timeCurrentTv,i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                UIHndler.removeMessages(UPDATE_UI);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress=seekBar.getProgress();
                //令视频播放的进度遵循SeekBar停止拖动的这一刻度
                videoView.seekTo(progress);
                UIHndler.sendEmptyMessage(UPDATE_UI);
            }
        });
        volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //设置当前设备的音量
                mAudiomanager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //横竖屏
        screenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iSFullScreen){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);
                }
            }
        });
        //控制ViedoView的手势事件
        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x=motionEvent.getX();
                float y=motionEvent.getY();

                switch (motionEvent.getAction()){
                    //手指落下屏幕的那一刻 一次
                    case MotionEvent.ACTION_DOWN:
                        lastX=x;
                        lastY=y;
                        break;
                    //手指在屏幕上移动 多次
                    case MotionEvent.ACTION_MOVE:
                        float detlaX=x-lastX;
                        float detlaY=y-lastY;
                        float absdetlaX=Math.abs(detlaX);
                        float absdetlaY=Math.abs(detlaY);
                        if (absdetlaX>thshold&&absdetlaY>thshold){
                            if(absdetlaX<absdetlaY){
                                isAdjust=true;
                            }else {
                                isAdjust=true;
                            }
                        }else if (absdetlaX<thshold&&absdetlaY<thshold){
                            isAdjust=true;
                        }else if (absdetlaX>thshold&&absdetlaY<thshold){
                            isAdjust=true;
                        }
                        Log.i(TAG,
                                "onTouch: 手势是否合法"+isAdjust);
                        if (isAdjust){
                            //在判断好当前手势事件已经合法的前提下，在去判断是调节音量或者是屏幕亮度
                            if (x<sereen_weith/2){
                                //调节亮度
                                if (detlaY>0){
                                    Log.e(TAG, "onTouch:降低亮度 "+ detlaY);
                                }else {
                                    Log.e(TAG, "onTouch:提高亮度 "+ detlaY);
                                }
                                changeBrightness(-detlaY);
                            }else {
                                //调节声音
                                if (detlaY>0){
                                    Log.e(TAG, "onTouch:降低声音 "+ detlaY);
                                }else {
                                    Log.e(TAG, "onTouch:提高声音 "+ detlaY);
                                }
                                changeVolumd(-detlaY);
                            }
                        }
                        lastX = x;
                        lastY = y;
                        break;
                    case MotionEvent.ACTION_UP:
                        progress_layout.setVisibility(View.GONE);
                        break;
                }
                return true;
            }
        });
    }
    FrameLayout progress_layout;
    private void changeVolumd(float detlay){
        int max = mAudiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int current = mAudiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int index = (int) (detlay/sereen_height*max*3);
        int volume = Math.max(current+index,0);

        mAudiomanager.setStreamVolume(AudioManager.STREAM_MUSIC,volume,0);
        if (progress_layout.getVisibility()==View.GONE){
            progress_layout.setVisibility(View.VISIBLE);
        }
        operation_bg.setImageResource(R.mipmap.video_volumn_bg);
        ViewGroup.LayoutParams l=operation_percent.getLayoutParams();
        l.width = (int)(PixelUtil.dp2px(this,94)*(float)volume/max);
        operation_percent.setLayoutParams(l);
        Log.i(TAG, "changeVolumd: "+volume);
        volumeSeekbar.setProgress(volume);
    }
    private void changeBrightness(float detlay){
WindowManager.LayoutParams l=getWindow().getAttributes();
        mBrightness=l.screenBrightness;
        float index = detlay/sereen_height/3;
        mBrightness += index;
        if (mBrightness>1.0f){
            mBrightness=1.0f;
        }
        if (mBrightness<0.01f){
            mBrightness=0.01f;
        }
        if (progress_layout.getVisibility()==View.GONE){
            progress_layout.setVisibility(View.VISIBLE);
        }
        operation_bg.setImageResource(R.mipmap.video_brightnes_bg);
        ViewGroup.LayoutParams ll=operation_percent.getLayoutParams();
        l.width = (int)(PixelUtil.dp2px(this,94)*mBrightness);
        operation_percent.setLayoutParams(ll);

        l.screenBrightness = mBrightness;
        getWindow().setAttributes(l);

    }
    public void getSDPath() {
        File sdDir = null;
        File sdDir1 = null;
        File sdDir2 = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED); //判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
            sdDir1 = Environment.getDataDirectory();
            sdDir2 = Environment.getRootDirectory();
            Log.i(TAG, "getSDPath:1 ");
        }else {
            Log.i(TAG, "getSDPath: 2");
        }
        System.out.println("getExternalStorageDirectory(): " + sdDir.toString());
        System.out.println("getDataDirectory(): " + sdDir1.toString());
        System.out.println("getRootDirectory(): " + sdDir2.toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        UIHndler.removeMessages(UPDATE_UI);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
