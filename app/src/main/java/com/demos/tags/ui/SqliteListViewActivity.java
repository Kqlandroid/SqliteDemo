package com.demos.tags.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.demos.tags.R;
import com.demos.tags.utile.Content;

import java.io.File;

public class SqliteListViewActivity extends AppCompatActivity {
private ListView lv;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_list_view);
        lv = (ListView) findViewById(R.id.lv);
        String path = getApplicationContext().getDatabasePath(Content.KEY_SQLITE_NAME).getPath();
        database=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);
        Cursor cursor=database.rawQuery("select * from "+ Content.KEY_tabler,null);
        //将数据源加载到适配器中
        /**
         * SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {

         */
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.layout_listview_item,cursor,new String[]{Content.KEY_id,Content.KEY_name
        ,Content.KEY_age},new int[]{R.id.tv_id,R.id.tv_name,R.id.tv_age},SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);
    }
}
