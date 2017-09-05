package com.demos.tags.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demos.tags.R;
import com.demos.tags.bean.Persion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class SqliteAdapter extends BaseAdapter {
    private List<Persion> list = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    public SqliteAdapter(Context context,List<Persion> list) {
        this.list=list;
        mLayoutInflater = LayoutInflater.from(context);
    }
    public List<Persion> addList(List<Persion> list){
        list.addAll(list);
        return list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = mLayoutInflater.inflate(R.layout.layout_listview_item,null,false);
            viewHolder = new ViewHolder();
            viewHolder.tvid = (TextView)view.findViewById(R.id.tv_id);
            viewHolder.tvname = (TextView)view.findViewById(R.id.tv_name);
            viewHolder.tvage = (TextView)view.findViewById(R.id.tv_age);
           view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvid.setText(list.get(i).get_id()+"");
        viewHolder.tvname.setText(list.get(i).getName());
        viewHolder.tvage.setText(list.get(i).getAge()+"");
        return view;
    }
    static class ViewHolder{
        TextView tvid,tvname,tvage;
    }
}
