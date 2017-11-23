package com.demos.tags.ui;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.demos.tags.R;
import com.demos.tags.adapter.MoreRecylerViewAdapter;
import com.demos.tags.bean.DataModelOne;
import com.demos.tags.bean.DataModelThree;
import com.demos.tags.bean.DataModelTwo;
import com.demos.tags.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewActivity extends AppCompatActivity {
    private static final String TAG = "RecylerViewActivity";
    private RecyclerView mRecyclerView;
    MoreRecylerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                if (type == TestBean.type_three){
                    return gridLayoutManager.getSpanCount();
                }else {
                    return 1;
                }
            }
        });
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                GridLayoutManager.LayoutParams l = (GridLayoutManager.LayoutParams)view.getLayoutParams();
                int spanSize = l.getSpanSize();
                int spanIndex = l.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()){
                    if (spanIndex == 1){
                        outRect.left = 0;
                    }else {
                        outRect.right = 10;
                    }
                }
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        adapter = new MoreRecylerViewAdapter(this);
        mRecyclerView.setAdapter(adapter);
        initData();
    }
    int colors[] = {R.color.colorAccent,R.color.colorPrimary,R.color.colorPrimaryDark};
    private void initData() {
        List<TestBean> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int type ;
            if (i <= 5 || (i > 15 && i < 20)){
                type = 1;
                Log.i(TAG, "initData:a "+type);
            }else if (i < 10 || i > 26){
                type = 2;
                Log.i(TAG, "initData:b "+type);
            }else {
                type = 3;
                Log.i(TAG, "initData:c "+type);
            }
            TestBean bean = new TestBean();
            bean.avatarColor = colors[ type - 1 ];
            bean.type = type;
            bean.content = "content:" + type;
            bean.name = "name：" + type;
            bean.contentColor = colors[ ( type + 1 ) % 3 ];
            list.add(bean);
        }
        List<DataModelOne> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModelOne bean = new DataModelOne();
            bean.avatarColor=colors[0];
            bean.name="name："+1;
            list1.add(bean);
        }
        List<DataModelTwo> list2 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            DataModelTwo bean = new DataModelTwo();
            bean.avatarColor = colors [ 1 ];
            bean.content = "content:" + 2;
            bean.name = "name：" + 2;
            list2.add(bean);
        }
        List<DataModelThree> list3 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            DataModelThree bean = new DataModelThree();
            bean.avatarColor = colors[2];
            bean.content = "content:" + 3;
            bean.name = "name：" + 3;
            bean.contentColor = colors[2];
            list3.add(bean);
        }
        adapter.addlist(list1,list2,list3);
        adapter.notifyDataSetChanged();
    }
}
