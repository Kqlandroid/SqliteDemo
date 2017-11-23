package com.demos.tags.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Administrator on 2017/11/14 0014.
 */

public abstract class BaseFragment extends Fragment {
    BaseActivity baseActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.baseActivity = (BaseActivity) context;
    }
    public abstract int getlayoutID();
    public abstract void layoutView(View view,Bundle savedInstanceState);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getlayoutID(),container,false);
        layoutView(view,savedInstanceState);
        return view;
    }
}
