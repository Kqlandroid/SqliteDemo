package com.demos.tags.ui;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.demos.tags.R;
import com.demos.tags.adapter.SqliteAdapter;
import com.demos.tags.bean.Persion;
import com.demos.tags.bean.TestBean;
import com.demos.tags.utile.Content;
import com.demos.tags.utile.DbManger;
import com.demos.tags.utile.SqliteDbHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MoreInsertActivity extends AppCompatActivity {
    private SqliteDbHelper helper;
    private ListView listView;
    SQLiteDatabase db;
    int totalNum;//表示当前控件加载数据的总条目
    int pageSize = 15;//表示每页展示的数据条目
    int pageNum;//表示总页码
    int currentPage = 1;//当前页码
    List<Persion> list = new ArrayList<>();
    SqliteAdapter adapter;
    boolean isDivPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_insert);
        helper = new SqliteDbHelper(this);
        listView = (ListView) findViewById(R.id.lv);
        String path = getApplicationContext().getDatabasePath(Content.KEY_SQLITE_NAME).getPath();
        db = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);
        totalNum = DbManger.getDataCount(db,Content.KEY_tabler);
        pageNum = (int) Math.ceil(totalNum/(double)pageSize);
        if (currentPage == 1){
            list = DbManger.getListCurrentPage(db,Content.KEY_tabler, currentPage,pageSize);
        }
        adapter = new SqliteAdapter(this,list);
        listView.setAdapter(adapter);
        adapter.addList(list);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollStare) {
                if (isDivPage&&AbsListView.OnScrollListener.SCROLL_STATE_IDLE == scrollStare)
                    if (currentPage<pageNum){
                        currentPage++;
                       //根据最新的页码加载获取集合存储到数据源中
                        list.addAll(DbManger.getListCurrentPage(db,Content.KEY_tabler,
                                currentPage,pageSize));
                        adapter.notifyDataSetChanged();
                    }
            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisbleItem, int visbleItemCount, int totalItemCount) {
                isDivPage=((firstVisbleItem+visbleItemCount)==totalItemCount);
            }
        });
    }
}
