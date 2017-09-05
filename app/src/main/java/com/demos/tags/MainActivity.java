package com.demos.tags;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.demos.tags.bean.Persion;
import com.demos.tags.utile.Content;
import com.demos.tags.utile.DbManger;
import com.demos.tags.utile.SqliteDbHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private SqliteDbHelper dbHelper;
    private TextView tv_add,tv_addContent,tv_updatecontet,tv_deletecontet,tv_selectcontet
            ,tv_addContentApi, tv_updatecontetApi, tv_deletecontetApi, tv_selectcontetApi, tv_phone,tv_RecyclerView,tv_listView,tv_listView2,tv_insertmore,tv_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = DbManger.getIntancce(this);
        tv_add = (TextView) findViewById(R.id.tv_addTabler);
        tv_add.setOnClickListener(this);
        tv_addContent = (TextView) findViewById(R.id.tv_addcontet);
        tv_addContent.setOnClickListener(this);
        tv_updatecontet = (TextView) findViewById(R.id.tv_updatecontet);
        tv_updatecontet.setOnClickListener(this);
        tv_deletecontet = (TextView) findViewById(R.id.tv_deletecontet);
        tv_deletecontet.setOnClickListener(this);
        tv_selectcontet = (TextView) findViewById(R.id.tv_selectcontet);
        tv_selectcontet.setOnClickListener(this);

//        Api
        tv_addContentApi = (TextView) findViewById(R.id.tv_addcontetApi);
        tv_addContentApi.setOnClickListener(this);
        tv_updatecontetApi = (TextView) findViewById(R.id.tv_updatecontetApi);
        tv_updatecontetApi.setOnClickListener(this);
        tv_deletecontetApi = (TextView) findViewById(R.id.tv_deletecontetApi);
        tv_deletecontetApi.setOnClickListener(this);
        tv_selectcontetApi = (TextView) findViewById(R.id.tv_selectcontetApi);
        tv_selectcontetApi.setOnClickListener(this);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_phone.setOnClickListener(this);
        tv_RecyclerView = (TextView) findViewById(R.id.tv_RecyclerView);
        tv_RecyclerView.setOnClickListener(this);
        tv_listView = (TextView) findViewById(R.id.tv_listView);
        tv_listView.setOnClickListener(this);
        tv_listView2 = (TextView) findViewById(R.id.tv_listView2);
        tv_listView2.setOnClickListener(this);
        tv_insertmore = (TextView) findViewById(R.id.tv_insertmore);
        tv_insertmore.setOnClickListener(this);
        tv_page = (TextView) findViewById(R.id.tv_page);
        tv_page.setOnClickListener(this);

        ExistSDCard();
    }
    private boolean ExistSDCard() {
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            Log.i(TAG, "ExistSDCard: true");
            return true;
        } else
            Log.i(TAG, "ExistSDCard: false");
            return false;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_addTabler:
                //创建数据库
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                break;
            case R.id.tv_addcontet:
//                插入数据
                db = dbHelper.getWritableDatabase();
                for (int i = 0; i < 30; i++) {
                    String sql="insert into "+ Content.KEY_tabler+" values ("+i+",'zhangsan"+i+"',20)";
                    DbManger.execSQl(db,sql);
                }


                db.close();
                break;
            case R.id.tv_updatecontet:
//                修改表数据
                db = dbHelper.getWritableDatabase();
                String updateSql = "update "+Content.KEY_tabler+" set "+Content.KEY_name+"='kql' where "+Content.KEY_id+"=1 ";
                DbManger.execSQl(db,updateSql);
                db.close();
                break;
            case R.id.tv_deletecontet:
                db=dbHelper.getWritableDatabase();
                String deleteSql="delete from "+Content.KEY_tabler+" where "+Content.KEY_id+"=1";
                DbManger.execSQl(db,deleteSql);
                db.close();
                break;
            case R.id.tv_selectcontet:
                SQLiteDatabase     db1=dbHelper.getWritableDatabase();
                String sql="select * from "+Content.KEY_tabler;
                Cursor cusor= DbManger.selectDataSql(db1,sql,null);
                List<Persion> list = DbManger.cursorTolist(cusor);
                for (Persion p:list) {
                    Log.i(TAG, "onClick: "+p.toString());
                }
                db1.close();
                break;
//            Api
            case R.id.tv_addcontetApi:
                db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put(Content.KEY_id,"3");
                values.put(Content.KEY_name,"123");
                values.put(Content.KEY_age,"52");
                long result= db.insert(Content.KEY_tabler,null,values);
                if (result>0){
                    Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "插入失败", Toast.LENGTH_SHORT).show();
                }
                db.close();
                break;
            case R.id.tv_updatecontetApi:
                db=dbHelper.getWritableDatabase();
                ContentValues updatevalues = new ContentValues();
                updatevalues.put(Content.KEY_name,"wngwu");
                long updateressult = db.update(Content.KEY_tabler,updatevalues,Content.KEY_id+"=?",new String[]{"2"});
                if (updateressult>0){
                    Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();
                }
                db.close();
                break;
            case R.id.tv_deletecontetApi:
                db=dbHelper.getWritableDatabase();
                int count=db.delete(Content.KEY_tabler,Content.KEY_id+"=?",new String[]{"2"});
                if (count>0){
                    Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "删除失败", Toast.LENGTH_SHORT).show();
                }
                db.close();
                break;
            case R.id.tv_selectcontetApi:
                db = dbHelper.getWritableDatabase();
                cusor = db.query(Content.KEY_tabler,null,Content.KEY_id+">?",new String[]{"10"},null,null,Content.KEY_id+" desc");
                list = DbManger.cursorTolist(cusor);
                for (Persion p:list){
                    Log.i(TAG, "onClick: "+p.toString());
                }
                db.close();
                break;
            case R.id.tv_phone:
                startActivity(new Intent(MainActivity.this,PhoneActivity.class));
                break;
            case R.id.tv_RecyclerView:
                startActivity(new Intent(MainActivity.this,RecylerViewActivity.class));
                break;
            case R.id.tv_listView:
                startActivity(new Intent(MainActivity.this,SqliteListViewActivity.class));
                break;
            case R.id.tv_listView2:
                startActivity(new Intent(MainActivity.this,CursorAdapterActivity.class));
                break;
            case R.id.tv_insertmore:
                initDatas();
                break;
            case R.id.tv_page:
                startActivity(new Intent(MainActivity.this,MoreInsertActivity.class));
                break;

        }

    }
    public void initDatas(){
        SQLiteDatabase database=dbHelper.getWritableDatabase();
        for (int i = 0; i < 100; i++) {
            String sql = "insert into "+
                    Content.KEY_tabler+" values ("+i+",'小米',22)";
            database.execSQL(sql);
        }
        //开启事务
        database.setTransactionSuccessful();
        //关闭事务
        database.endTransaction();
        database.close();
    }
}
