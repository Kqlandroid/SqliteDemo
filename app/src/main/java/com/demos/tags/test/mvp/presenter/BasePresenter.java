package com.demos.tags.test.mvp.presenter;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Administrator on 2017/11/23 0023.
 */

public class BasePresenter{
    Context mContext;
    public void attach(Context context){
        this.mContext = context;
    }
    protected void onResume() {}
    protected void onDestroy() {}
    protected void onPause() { mContext = null;}
    public void onStop(){};
}
