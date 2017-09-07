package com.demos.tags;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.demos.tags.bean.Deatil;
import com.demos.tags.bean.MyInfo;
import com.demos.tags.utile.utils.StringUtils;
import com.demos.tags.utile.utils.XmlUtils;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Headers;
import retrofit2.Call;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_login)
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Log.i(TAG, "ssssss: ");
        Request request = ItheimaHttp.newGetRequest("action/api/login_validate");//apiUrl格式："xxx/xxxxx"
        request.putParams("kep_login",1)
                .putParams("username","384807683@qq.com")
                .putParams("pwd","maweiqi1");
        Call call = ItheimaHttp.send(request, new HttpResponseListener<String>() {
            @Override
            public void onResponse(String s, Headers headers) {
                Log.i(TAG, "onResponse: "+s);
             MyInfo myInfo = XmlUtils.toBean(MyInfo.class,s.getBytes());
                Log.i(TAG, "onResponse: "+myInfo.user.name);
            }
        });
    }

    @OnClick(R.id.tv_login)
    public void onViewClicked() {

    }
}
