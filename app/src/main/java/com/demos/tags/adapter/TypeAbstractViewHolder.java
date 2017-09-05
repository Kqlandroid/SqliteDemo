package com.demos.tags.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demos.tags.bean.TestBean;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public abstract class TypeAbstractViewHolder<T> extends RecyclerView.ViewHolder {
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bindHolder(T bean);
}
