package com.demos.tags.bsincess;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class HttpUtil {
    String mUrl;
    Map<String , String> mParem;
    HttpRepose mHttpRespose;
    Handler handler = new Handler(Looper.getMainLooper());
    private final OkHttpClient client  = new OkHttpClient();
    public interface HttpRepose{
        public  void OnSuccess(Object objects);
        public  void OnFail(String error);
    }
    public HttpUtil(HttpRepose respose){
        mHttpRespose = respose;
    }
    public void sendPostHttp(String url, Map<String , String> parem){
        sendHttp(url,parem,true);
    }
    public void sendGetHttp(String url, Map<String , String> parem){
        sendHttp(url,parem,false);
    }
    public void sendHttp(String url,Map<String,String> parem,boolean isPost){
        mUrl = url;
        mParem = parem;
//        编写Http请求
        run(isPost);
    }

    private void run(boolean isPost) {
        final Request request = createRequest(isPost);
        //创建请求队列
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (mHttpRespose!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mHttpRespose.OnFail("请求错误");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (mHttpRespose==null){
                    return;
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!response.isSuccessful()){
                            mHttpRespose.OnFail("请求失败：code"+response);
                        }else {
                            try {
                                mHttpRespose.OnSuccess(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                                mHttpRespose.OnFail("请求失败：code"+response);
                            }
                        }
                    }
                });
            }
        });
    }

    private Request createRequest(boolean isPost) {
        Request request;
        if (isPost){
            MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder();
            requestBodyBuilder.setType(MultipartBody.FORM);
//            遍历map请求参数
            Iterator<Map.Entry<String,String>> iterator = mParem.entrySet().iterator();
            while ((iterator.hasNext())){
                Map.Entry<String,String>  entry = iterator.next();
                requestBodyBuilder.addFormDataPart(entry.getKey(),entry.getValue());
            }
            request = new okhttp3.Request.Builder().url(mUrl)
                    .post(requestBodyBuilder.build()).build();
        }else {
            String urlStr = mUrl+"?"+MapParamToString(mParem);
            request = new Request.Builder().url(urlStr).build();
        }
        return request;
    }
    private String MapParamToString(Map<String,String>param){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<String,String>> iterator = param.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            stringBuilder.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        String str=stringBuilder.toString().substring(0,stringBuilder.length()-1);
        return str;
    }
}
