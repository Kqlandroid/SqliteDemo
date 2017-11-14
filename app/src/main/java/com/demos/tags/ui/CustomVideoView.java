package com.demos.tags.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.VideoView;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class CustomVideoView extends VideoView {
    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
int defultweight=1920;
    int defaultheight=1080;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = getDefaultSize(defultweight, widthMeasureSpec);
        int height = getDefaultSize(defaultheight, heightMeasureSpec);
        Log.i("tag", "onMeasure:1 "+width);
        Log.i("tag", "onMeasure:2 "+height);
        setMeasuredDimension(width, height);
    }
}
