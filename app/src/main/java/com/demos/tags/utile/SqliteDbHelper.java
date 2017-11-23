package com.demos.tags.utile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class SqliteDbHelper extends SQLiteOpenHelper {
    private static final String TAG = "SqliteDbHelper";

    /**
     * 构造函数
     * @param context 上下文
     * @param name 数据库名称
     * @param factory 游标工厂
     * @param version 数据库版本
     */
    public SqliteDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public SqliteDbHelper(Context context){
        super(context,Content.KEY_SQLITE_NAME,null,Content.KEY_VERION);
    }
    public SqliteDbHelper(Context context,String name){
        super(context,getMyDatabaseName(name),null,Content.KEY_VERION);
    }
    private static String getMyDatabaseName(String name){
        String databasename = name;
        boolean isSdcardEnable = false;
        String state = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(state)){//SDCard是否插入
            isSdcardEnable = true;
        }
        String dbPath = null;
        if(isSdcardEnable){
            for (int i = 0; i < 2; i++) {
                dbPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
            }

        }else{//未插入SDCard，建在内存中

        }
        File dbp = new File(dbPath);
        if(!dbp.exists()){
            dbp.mkdirs();
        }
        databasename = dbPath + databasename;
        return databasename;
    }
    /**
     * 创建数据库时回调
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate: ");
        String sql="create table "+
                Content.KEY_tabler+" ("+Content.KEY_id+" Integer primary key ,"+Content.KEY_name
                +" varchar(10), "+Content.KEY_age+" Integer)";
        db.execSQL(sql);//执行生sql语句
    }

    /**
     * 有版本更新是回调
     * @param sqLiteDatabase
     * @param i 旧版本
     * @param i1 新版本
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i(TAG, "onUpgrade: ");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.i(TAG, "onOpen: ");
    }
}
