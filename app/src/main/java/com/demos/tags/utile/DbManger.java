package com.demos.tags.utile;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.demos.tags.bean.Persion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class DbManger {
    private static SqliteDbHelper dbHelper;
    public static SqliteDbHelper getIntancce(Context context){
        if (dbHelper==null){
            dbHelper =new SqliteDbHelper(context);
        }
        return dbHelper;
    }
    public static void execSQl(SQLiteDatabase db,String sql){
        if (db!=null){
            if (sql!=null&&!"".equals(sql)){
                db.execSQL(sql);
            }
        }
    }
    public static Cursor selectDataSql(SQLiteDatabase db, String sql,String [] selectionargs){
        Cursor cursor = null;
        if (db !=null){
            cursor = db.rawQuery(sql,selectionargs);
        }
        return cursor;
    }
    public static List<Persion> cursorTolist(Cursor cursor){
        List<Persion> list = new ArrayList<>();
        while (cursor.moveToNext()){
            int cloumindex = cursor.getColumnIndex(Content.KEY_id);
            int id = cursor.getInt(cloumindex);
            String name = cursor.getString(cursor.getColumnIndex(Content.KEY_name));
            int age =cursor.getInt(cursor.getColumnIndex(Content.KEY_age));
            Persion p = new Persion(id,name,age);
            list.add(p);
        }
        return list;
    }

    /**
     * 根据数据库以及数据表名称获取表中的总条目
     * @param database 数据库对象
     * @param table 数据库表面
     * @return
     */
    public static int getDataCount(SQLiteDatabase database,String table){
        int count=0;
        if (database!=null){
            Cursor cursor=database.rawQuery("select * from "+Content.KEY_tabler,null);
            count=cursor.getCount();
        }
        return count;
    }

    /**
     * 根据当前的页码查询获取该页码对应的集合数据
     * @param database 数据库
     * @param table 数据表名称
      * @param currentPage 当前页码
     * @param pageSize 当前页码
     * @return
     */
    public static  List<Persion> getListCurrentPage(SQLiteDatabase database,String table,int currentPage,int pageSize){
       int index = (currentPage - 1) * pageSize;//获取当前页码第一条数据的下标
        Cursor cursor = null;
        if (database != null){
            String sql = "select * from "+table+" limit ?,?";
            cursor = database.rawQuery(sql,new String[]{index+"",pageSize+""});
        }
        return cursorTolist(cursor);
    }
}
