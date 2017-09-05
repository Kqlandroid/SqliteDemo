package com.demos.tags.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.demos.tags.MainActivity;
import com.demos.tags.R;
import com.demos.tags.bean.DataModelOne;
import com.demos.tags.bean.DataModelThree;
import com.demos.tags.bean.DataModelTwo;
import com.demos.tags.bean.TestBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class MoreRecylerViewAdapter extends RecyclerView.Adapter {
    private LayoutInflater mLayoutInflater;
    private List<TestBean> mlist = new ArrayList<>();
    private static final int KEY_TYPEONE = 1;
    private static final int KEY_TYPETWO = 2;
    private static final int KEY_TYPETHREE = 3;
    public MoreRecylerViewAdapter(Context context) {
        this.mLayoutInflater = mLayoutInflater.from(context);
    }
    private List<DataModelOne> list1;
    private List<DataModelTwo> list2;
    private List<DataModelThree> list3;
    private List<Integer> types = new ArrayList<>();
    private Map<Integer,Integer> mPositions = new HashMap<>();
    public void addlist(List<DataModelOne> list1,
                        List<DataModelTwo> list2, List<DataModelThree> list3) {
        addListType(KEY_TYPEONE,list1);
        addListType(KEY_TYPETWO,list2);
        addListType(KEY_TYPETHREE,list3);
        this.list1=list1;
        this.list2=list2;
        this.list3=list3;
    }

    private void addListType(int type,List list){
        mPositions.put(type,types.size());
        for (int i = 0; i < list.size(); i++) {
            types.add(type);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TestBean.type_one:
                return new TypeOneHolder(mLayoutInflater.inflate(R.layout.layout_item_1,parent,false));
            case TestBean.type_two:
                return new TypeTwoHolder(mLayoutInflater.inflate(R.layout.layout_item_2,parent,false));
            case TestBean.type_three:
                return new TypeThreeHolder(mLayoutInflater.inflate(R.layout.layout_item_3,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        int reaPosition = position-mPositions.get(viewType);
        switch (viewType){
            case TestBean.type_one:
                ((TypeOneHolder)holder).bindHolder(list1.get(reaPosition));
                break;
            case TestBean.type_two:
                ((TypeTwoHolder)holder).bindHolder(list2.get(reaPosition));
                break;
            case TestBean.type_three:
                ((TypeThreeHolder)holder).bindHolder(list3.get(reaPosition));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }

    @Override
    public int getItemCount() {
        return types==null?0:types.size();
    }
}
