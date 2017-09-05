package com.demos.tags.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demos.tags.R;
import com.demos.tags.bean.DataModelThree;
import com.demos.tags.bean.TestBean;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class TypeThreeHolder extends TypeAbstractViewHolder<DataModelThree>{
    private static final String TAG = "TypeThreeHolder";
    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentColor;
    public TypeThreeHolder(View itemView) {
        super(itemView);
        avatar=(ImageView)itemView.findViewById(R.id.acatar);
        name = (TextView)itemView.findViewById(R.id.name);
        content = (TextView)itemView.findViewById(R.id.content);
        contentColor=(ImageView)itemView.findViewById(R.id.contentImager);
        itemView.setBackgroundColor(Color.YELLOW);
    }
    @Override
    public void bindHolder(DataModelThree bean){
        avatar.setBackgroundResource(bean.avatarColor);
        name.setText(bean.name);
        content.setText(bean.content);
        contentColor.setBackgroundResource(bean.contentColor);
        Log.i(TAG, "bindHolder: 3"+bean.content);
    }
}
