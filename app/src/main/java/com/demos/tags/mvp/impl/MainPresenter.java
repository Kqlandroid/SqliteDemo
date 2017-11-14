package com.demos.tags.mvp.impl;

import com.demos.tags.bean.Phone;
import com.demos.tags.bsincess.HttpUtil;
import com.demos.tags.mvp.MvpMainView;
import com.google.gson.Gson;
import com.google.gson.internal.ObjectConstructor;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class MainPresenter extends BasePresenter {
    String mUrl="https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
    private MvpMainView mvpMainView;
    Phone mPhone;
    public Phone getPhoneInfo(){
        return mPhone;
    }
    public MainPresenter(MvpMainView mainView){
        mvpMainView = mainView;
    }
    public void sarchPhoneInfo(String phone){
        if (phone.length() != 11){
            mvpMainView.showToast("请输入正确的手机号码!");
        }
        mvpMainView.showLoading();
//        http请求
        sendHttp(phone);
    }

    private void sendHttp(String phone) {
        Map<String,String> map = new HashMap<>();
        map.put("tel",phone);
        HttpUtil httpUtil = new HttpUtil(new HttpUtil.HttpRepose() {
            @Override
            public void OnSuccess(Object objects) {
                String json = objects.toString();
                int index = json.indexOf("{");
                json = json.substring(index,json.length());
//                //使用JSONobject
                mPhone = parseMobileWiteOrgJson(json);
//                Gson
                mPhone = parseModeWiteGson(json);
////                FastJson
                mPhone = parseModeWiteFastJson(json);
                mvpMainView.hindLoading();
                mvpMainView.updateView();
            }

            @Override
            public void OnFail(String error) {
                mvpMainView.showToast(error);
                mvpMainView.hindLoading();
            }
        });
        httpUtil.sendGetHttp(mUrl,map);
    }
    private Phone parseMobileWiteOrgJson(String json){
        Phone phone = new Phone();
        try {
            JSONObject jsonObject = new JSONObject(json);
            String value = jsonObject.getString("telString");
            phone.setTelString(value);
            value = jsonObject.getString("province");
            phone.setProvince(value);
            value = jsonObject.getString("catName");
            phone.setCatname(value);
            value = jsonObject.getString("carrier");
            phone.setCarrier(value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return phone;
    }
    private Phone parseModeWiteGson(String json) {
        Phone phone = new Gson().fromJson(json,Phone.class);
        return phone;
    }
    private Phone parseModeWiteFastJson(String json){
        Phone phone = com.alibaba.fastjson.JSONObject.parseObject(json,Phone.class);
        return phone;
    }
}
