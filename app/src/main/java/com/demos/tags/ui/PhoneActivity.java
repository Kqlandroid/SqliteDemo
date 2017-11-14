package com.demos.tags.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demos.tags.R;
import com.demos.tags.bean.Phone;
import com.demos.tags.mvp.MvpMainView;
import com.demos.tags.mvp.impl.MainPresenter;

public class PhoneActivity extends AppCompatActivity implements MvpMainView ,View.OnClickListener,View.OnKeyListener{
    MainPresenter mainPresenter;
    EditText et_phone;
    TextView tvfindPhone,phoneNumber,provnce,type,carrier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        initview();
    }

    private void initview() {
        et_phone = (EditText) findViewById(R.id.et_phone);
        tvfindPhone = (TextView) findViewById(R.id.tv_findPhone);
        tvfindPhone.setOnClickListener(this);
        phoneNumber = (TextView) findViewById(R.id.tv_phone);
        provnce = (TextView) findViewById(R.id.tv_provide);
        type = (TextView) findViewById(R.id.tv_operator);
        carrier = (TextView) findViewById(R.id.tv_home_operator);
        mainPresenter = new MainPresenter(this);
        mainPresenter.attach(this);
    }

    @Override
    public void showLoading() {
        if (progressDialog == null){
            progressDialog = new ProgressDialog(this);
        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle("");
            progressDialog.setMessage("加载中...");
        }
        progressDialog.show();
    }
    ProgressDialog progressDialog;

    @Override
    public void hindLoading() {
        if (progressDialog.isShowing() && progressDialog != null){
            progressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateView() {
        Phone phone = mainPresenter.getPhoneInfo();
        phoneNumber.setText("手机号码：" + ( phone.getTelString() == null ? "xxxxx" : phone.getTelString()) );
        provnce.setText("省份：" + ( phone.getProvince() == null ? "xxxxxx" : phone.getProvince()) );
        type.setText("运营商：" + ( phone.getCatname() == null ? "xxxxxx" : phone.getCatname()) );
        carrier.setText("归属地运营商：" + ( phone.getCarrier() == null ? "xxxxxx" : phone.getCarrier()) );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_findPhone:
                mainPresenter.sarchPhoneInfo(et_phone.getText().toString()+"");
                break;
        }
    }

    @Override
    public boolean onKey(View view, int KeyCode, KeyEvent keyEvent) {
        if( KeyCode == KeyEvent.KEYCODE_ENTER ) {
            mainPresenter.sarchPhoneInfo(et_phone.getText().toString() + "");
        }
        return false;
    }
}
