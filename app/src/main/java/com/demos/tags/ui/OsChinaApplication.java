package com.demos.tags.ui;

import android.content.Context;

import com.itheima.retrofitutils.ItheimaHttp;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class OsChinaApplication extends android.app.Application {
    Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ItheimaHttp.init(context, "https://www.oschina.net/");//使用前必须调用（如果调用过则不需要重复调用）
    }
}
