package com.demos.tags.test.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demos.tags.R;
import com.demos.tags.test.mvp.model.Phone;
import com.demos.tags.test.mvp.presenter.LoginPresenter;
import com.demos.tags.test.mvp.view.MVPLoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/23 0023.
 */

public class TestActivity extends AppCompatActivity implements MVPLoginView {
    LoginPresenter mPresenter;
    ProgressDialog progressDialog;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载....");
        mPresenter = new LoginPresenter(this);
        mPresenter.attach(this);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showlodaning() {
        if (progressDialog==null){
            progressDialog.show();
        }
    }

    @Override
    public void hindingView() {
        if (progressDialog.isShowing()||progressDialog!=null){
            progressDialog.dismiss();
        }
    }

    @Override
    public void updateview() {
//             * mts : 1362550
//                * province : 安徽
//                * catName : 中国移动
//                * telString : 13625501946
//                * areaVid : 30509
//                * ispVid : 3236139
//                * carrier : 安徽移动
        Phone phone = mPresenter.getPhone();
        tvContent.setText(
                          ""+phone.getCarrier()+
                        "\n"+phone.getTelString()+
                        "\n" +phone.getCarrier()+
                        "\n" +phone.getProvince()+
                        "\n"+phone.getAreaVid()+
                        "\n"+phone.getIspVid()+
                        "\n"+phone.getMts());
    }

    @OnClick(R.id.btn_ok)
    public void onViewClicked() {
        etPhone.setSelection(etPhone.getText().toString().length());
        mPresenter.savePhone(etPhone.getText().toString());
    }
}
