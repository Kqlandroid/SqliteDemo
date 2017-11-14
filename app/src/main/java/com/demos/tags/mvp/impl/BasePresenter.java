package com.demos.tags.mvp.impl;

import android.content.Context;

import com.demos.tags.utile.Content;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class BasePresenter {
    Context mContext;
    public void attach(Context context){
        mContext = context;
    }
    public void onPause(){}
    public void onResume(){}
    public void onDestroy(){
        mContext = null;
    }
}
