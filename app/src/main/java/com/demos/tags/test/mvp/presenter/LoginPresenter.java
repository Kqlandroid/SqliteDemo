package com.demos.tags.test.mvp.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.demos.tags.bsincess.HttpUtil;
import com.demos.tags.mvp.impl.*;
import com.demos.tags.test.mvp.model.Phone;
import com.demos.tags.test.mvp.view.MVPLoginView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/23 0023.
 */

public class LoginPresenter  extends BasePresenter {
    MVPLoginView mvpLoginView;
    Phone mPhone;
    String mUrl = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
    @Override
    public void attach(Context context) {
        super.attach(context);
    }

    public Phone getPhone() {
        return mPhone;
    }

    public LoginPresenter(MVPLoginView mvpLoginView) {
        this.mvpLoginView = mvpLoginView;
    }
    public void savePhone(String phone){
        if (phone.length()!=11){
            Toast.makeText(mContext, "手机号码不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        mvpLoginView.showlodaning();
        submitInfo(phone);
    }
    private void submitInfo(String phone){
        Map<String,String> map = new HashMap<>();
        map.put("tel",phone);
        HttpUtil httpUtil = new HttpUtil(new HttpUtil.HttpRepose() {
            @Override
            public void OnSuccess(Object objects) {
                String repose = objects.toString();
                Log.i("OnSuccess", "OnSuccess: "+repose);
                int index = repose.indexOf("{");
                repose = repose.substring(index,repose.length());
                mPhone = getphoneInfo(repose);
                mvpLoginView.hindingView();
                mvpLoginView.updateview();
            }

            @Override
            public void OnFail(String error) {
                mvpLoginView.showToast(error);
                mvpLoginView.hindingView();
            }
        });
        httpUtil.sendGetHttp(mUrl,map);
    }
    private Phone getphoneInfo(String respose){
        mPhone = new Gson().fromJson(respose,Phone.class);
        return mPhone;
    }
}
