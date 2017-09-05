package com.demos.tags.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demos.tags.R;
import com.demos.tags.bean.DataModelOne;
import com.demos.tags.bean.DataModelThree;
import com.demos.tags.bean.DataModelTwo;
import com.demos.tags.bean.TestBean;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class TypeTwoHolder extends TypeAbstractViewHolder<DataModelTwo>{
    private static final String TAG = "TypeTwoHolder";
    public ImageView avatar;
    public TextView name;
    public TextView content;
    public TypeTwoHolder(View itemView) {
        super(itemView);
        avatar=(ImageView)itemView.findViewById(R.id.acatar);
        name = (TextView)itemView.findViewById(R.id.name);
        content = (TextView)itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.GRAY);
    }
    @Override
    public void bindHolder(DataModelTwo bean){
        avatar.setBackgroundResource(bean.avatarColor);
        name.setText(bean.name);
        content.setText(bean.content);

        Log.i(TAG, "bindHolder:2 "+bean.content);
    }

}
