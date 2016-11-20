package com.example.mycontacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by 茹丽盈 on 2016/11/18.
 */

public class ContactsMessageActivity extends AppCompatActivity{
    private EditText nameet;
    private EditText mobileet;
    private EditText qqet;
    private EditText danweiet;
    private EditText addresset;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        setTitle("联系人信息");

        nameet= (EditText) findViewById(R.id.name);
        mobileet= (EditText) findViewById(R.id.mobile);
        qqet= (EditText) findViewById(R.id.qq);
        danweiet= (EditText) findViewById(R.id.danwei);
        addresset= (EditText) findViewById(R.id.address);

        nameet.setText("姓名："+user.getName());
        mobileet.setText("电话："+user.getMobile());
        qqet.setText("QQ:"+user.getQq());
        danweiet.setText("单位："+user.getDanwei());
        addresset.setText("地址："+user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
