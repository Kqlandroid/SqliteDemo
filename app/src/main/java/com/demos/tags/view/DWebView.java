package com.demos.tags.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

public class DWebView extends WebView {


    public DWebView(Context context) {
        super(context);
        init();
    }

    public DWebView(Context context, AttributeSet attrs) {
        super(context, attrs); init();
    }

    public DWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context,attrs,defStyleAttr,defStyleRes);
        init();
    }

//    public DWebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
//        super(context, attrs, defStyleAttr, privateBrowsing); init();
//    }

    private void init() {

    }
}
