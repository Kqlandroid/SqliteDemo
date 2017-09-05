package com.demos.tags.utile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
