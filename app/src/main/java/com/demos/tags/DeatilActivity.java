package com.demos.tags;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.demos.tags.bean.Comment;
import com.demos.tags.bean.Deatil;
import com.demos.tags.bean.DetailComment;
import com.demos.tags.utile.utils.XmlUtils;
import com.demos.tags.view.CircleImageView;
import com.demos.tags.view.FloorView;
import com.demos.tags.view.TweetTextView;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import retrofit2.Call;

public class DeatilActivity extends AppCompatActivity {
    private static final String TAG = "DeatilActivity";
    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.tv_it)
    TextView tvIt;
    @BindView(R.id.tv_commcontent)
    TextView tvCommcontent;
    @BindView(R.id.tv_pl)
    TextView tvPl;
    @BindView(R.id.abouts_layout)
    LinearLayout aboutsLayout;
    @BindView(R.id.recommend_layout)
    LinearLayout recommendLayout;
    @BindView(R.id.comment_layout)
    LinearLayout commentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatil);
        ButterKnife.bind(this);
        if (getIntent() != null) {
            int id = getIntent().getIntExtra("id", 0);
            Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
            Request request = ItheimaHttp.newGetRequest("action/apiv2/news?id=" + id);//apiUrl格式："xxx/xxxxx"
            Call call = ItheimaHttp.send(request, new HttpResponseListener<Deatil>() {
                @Override
                public void onResponse(Deatil deatil, Headers headers) {
//                    webview.loadUrl("");
                    tvOne.setText(deatil.getResult().getTitle());
                    tvTwo.setText(deatil.getResult().getPubDate());
                    List<Deatil.ResultBean.AboutsBean> aboutsBeenlist = deatil.getItemDatas();
                    for (int i = 0; i < aboutsBeenlist.size(); i++) {
                        View view = LayoutInflater.from(DeatilActivity.this).inflate(R.layout.abouts_item_layout, null, false);
                        TextView tvdetils = (TextView) view.findViewById(R.id.tv_detils);
                        if (aboutsBeenlist.size() > 0 || aboutsBeenlist != null) {
                            tvdetils.setText(aboutsBeenlist.get(i).getTitle());
                            aboutsLayout.addView(view);
                        }
                    }
                }
            });
            request = ItheimaHttp.newGetRequest("action/apiv2/comment?parts=refer,reply&sourceId="+id+"&type=6");//apiUrl格式："xxx/xxxxx"
            call = ItheimaHttp.send(request, new HttpResponseListener<DetailComment>() {
                @Override
                public void onResponse(DetailComment deatil, Headers headers) {
//

                    List<DetailComment.ResultBean.ItemsBean> imtemsBeenlist = deatil.getResult().getItems();
                    for (int i = 0; i < imtemsBeenlist.size(); i++) {
                        View view = LayoutInflater.from(DeatilActivity.this).
                                inflate(R.layout.lay_comment_item_layout, null, false);
                        CircleImageView ivAvatar = (CircleImageView) view.findViewById(R.id.iv_avatar);
                        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
                        TextView tvPubDate = (TextView) view.findViewById(R.id.tv_pub_date);
                        ImageView btnComment = (ImageView) view.findViewById(R.id.btn_comment);
                        FloorView lyRefers = (FloorView) view.findViewById(R.id.ly_refers);
                        TweetTextView tvContent = (TweetTextView) view.findViewById(R.id.tv_content);
                        LinearLayout layRefer = (LinearLayout) view.findViewById(R.id.lay_refer);
                        View viewline = (View) view.findViewById(R.id.view_line);

                        if (imtemsBeenlist.size() > 0 || imtemsBeenlist != null) {
                            DetailComment.ResultBean.ItemsBean bean = imtemsBeenlist.get(i);
                            Glide.with(DeatilActivity.this).load(bean.getAuthorPortrait()).into(ivAvatar);
                            tvName.setText(bean.getAuthor());
                            tvPubDate.setText(bean.getPubDate());
//                            lyRefers.setComments(bean.getRefer().getReferBeanXList());
                            commentLayout.addView(view);
                        }
                    }
                }
            });
        }
    }
}
