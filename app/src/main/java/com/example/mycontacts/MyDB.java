package com.example.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.id.content;

/**
 * Created by 茹丽盈 on 2016/10/24.
 */

public class MyDB extends SQLiteOpenHelper{
    private static String DB_NAME="My_DB.db";
    private static int DB_VERDION=2;
    private SQLiteDatabase db;

    public MyDB(Context context) {
        super(context, name, factory, version);
        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //打开数据库
    public SQLiteDatabase openConnection(){
        if (!db.isOpen()){
            db=getWritableDatabase();
        }
        return db;
    }

    //关闭数据库
    public void closeConnection(){
        try{
            if (db!=null&&db.isOpen()){
                db.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //创建数据表
    public boolean createTable(String createTableSql){
        try{
            openConnection();
            db.execSQL(createTableSql);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //保存数据
    public boolean save(String tableName, ContentValues values){
        try{
            openConnection();
            db.insert(tableName,null,values);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    //更新数据
    public boolean update(String table, ContentValues values,String whereClause,String[] whereArge){
        try{
            openConnection();
            db.update(table,values,whereClause,whereArge);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    //删除数据
    public boolean delete(String table,String deleteSQL,String obj[]){
        try{
            openConnection();
            db.delete(table,deleteSQL,obj);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    //查找数据
    public Cursor find(String findSQL, String obj[]){
        try{
            openConnection();
            Cursor cursor=db.rawQuery(findSQL,obj);
            return cursor;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //数据表是否存在
    public boolean isExist(String tablename){
        try{
            openConnection();
            String sql="selest count(*)xcount from"+tablename;
            db.rawQuery(sql,null).close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }
}
