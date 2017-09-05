package com.demos.tags;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.demos.tags.utile.Content;

import java.io.File;

public class CursorAdapterActivity extends AppCompatActivity {
    private ListView listView;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_adapter);
        listView= (ListView) findViewById(R.id.lv);
        String path= Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator+"info.db";
        database=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);
        Cursor cursor=database.rawQuery("select * from "+ Content.KEY_tabler,null);
        MyCursorAapter adapter=new MyCursorAapter(CursorAdapterActivity.this,cursor,CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(adapter);
    }
    private class MyCursorAapter extends CursorAdapter{
        //构造函数
        public MyCursorAapter(Context context, Cursor c,int flage) {
            super(context, c,flage);
        }

        /**
         * 创建适配器恐惧中的每个item对应的view对象
         * @param context 上下文
         * @param cursor 数据源cursor对象
         * @param viewGroup 当前item的副、父布局
         * @return
         */
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_listview_item,null,false);
            return view;
        }

        /**
         * 通过newview（）方法确定了每个item展示的viw对象，在binview()中
         * 对布局中的控件进行填充
         * @param view 由newView（）返回的每项view对象
         * @param context 上下文
         * @param cursor 数据源 cursor
         */
        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView tvid = (TextView)view.findViewById(R.id.tv_id);
            TextView tvname = (TextView)view.findViewById(R.id.tv_name);
            TextView tvage= (TextView)view.findViewById(R.id.tv_age);
            tvid.setText(cursor.getInt(cursor.getColumnIndex(Content.KEY_id))+"");
            tvname.setText(cursor.getString(cursor.getColumnIndex(Content.KEY_name)));
            tvage.setText(cursor.getInt(cursor.getColumnIndex(Content.KEY_age))+"");
        }
    }
}
