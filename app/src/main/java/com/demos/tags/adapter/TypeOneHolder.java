package com.demos.tags.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demos.tags.R;
import com.demos.tags.bean.DataModelOne;
import com.demos.tags.bean.TestBean;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class TypeOneHolder extends TypeAbstractViewHolder<DataModelOne>{
    public ImageView avatar;
    TextView name;
    public TypeOneHolder(View itemView) {
        super(itemView);
        avatar=(ImageView)itemView.findViewById(R.id.acatar);
        name = (TextView)itemView.findViewById(R.id.name);
    itemView.setBackgroundColor(Color.GREEN);
    }
    @Override
    public void bindHolder(DataModelOne bean){
        avatar.setBackgroundResource(bean.avatarColor);
        name.setText(bean.name);
    }
}
