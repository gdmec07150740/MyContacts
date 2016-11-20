package com.example.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

/**
 * Created by 茹丽盈 on 2016/10/24.
 */

public class ContactsTable {
    //数据表名常量
    private final static String TABLENAME="ContactsTablePR";
    //声明数据库对象
    private static  MyDB db;

    //构造方法
    public ContactsTable(Context context){
        db=new MyDB(context);
        if (!db.isExist(TABLENAME)){
            String createTableSQL="create table if not exists"+TABLENAME+
                    "(id_DB integer"+
                    "primary key autoincrement,"+
                    User.NAME+"VARCHAR,"+
                    User.MOBILE+"VARCHAR,"+
                    User.QQ+"VARCHAR,"+
                    User.DANWEI+"VARCHAR,"+
                    User.ADDRESS+"VARCHAR,)";
            db.createTable(createTableSQL);
        }
    }

    //增加数量
    public boolean addData(User user){
        ContentValues values=new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.QQ,user.getQq());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.ADDRESS,user.getAddress());
        return db.save(TABLENAME,values);
    }

    public User getUserById(int id){
        Cursor cursor=null;
        User temp=new User();
        try {
            cursor=db.find("select * from "+TABLENAME+"where"+"id_DB=?",new String[]{id+""});
            cursor.moveToNext();
            temp.setId_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
            temp.setName(cursor.getString(cursor.getColumnIndex(User.NAME)));
            temp.setMobile(cursor.getString(cursor.getColumnIndex(User.MOBILE)));
            temp.setDanwei(cursor.getString(cursor.getColumnIndex(User.DANWEI)));
            temp.setQq(cursor.getString(cursor.getColumnIndex(User.QQ)));
            temp.setAddress(cursor.getString(cursor.getColumnIndex(User.ADDRESS)));

            Log.d("aa",temp.getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (cursor!=null){
                cursor.close();
            }
            db.closeConnection();
        }
        return null;
    }

    public boolean updateUser(User user){
        ContentValues values=new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.QQ,user.getQq());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.ADDRESS,user.getAddress());
        return db.update(TABLENAME,values,"id_DB",new String[]{user.getId_DB()+""});
    }
}
