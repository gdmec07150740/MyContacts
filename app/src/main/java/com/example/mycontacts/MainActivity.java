package com.example.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameet;
    private EditText mobileet;
    private EditText qqet;
    private EditText danweiet;
    private EditText addresset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("添加联系人");

        nameet= (EditText) findViewById(R.id.name);
        mobileet= (EditText) findViewById(R.id.mobile);
        qqet= (EditText) findViewById(R.id.qq);
        danweiet= (EditText) findViewById(R.id.danwei);
        addresset= (EditText) findViewById(R.id.address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"SAVE");
        menu.add(Menu.NONE,2,Menu.NONE,"RETURN");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if(!nameet.getText().toString().equals("")){
                    User user=new User();
                    user.setName(nameet.getText().toString());
                    user.setMobile(mobileet.getText().toString());
                    user.setQq(qqet.getText().toString());
                    user.setDanwei(danweiet.getText().toString());
                    user.setAddress(addresset.getText().toString());

                    ContactsTable ctable=new ContactsTable(MainActivity.this);
                    if (ctable.addData(user)){
                        Toast.makeText(MainActivity.this,"添加成功！",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"添加失败！",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"请输入要添加的内容！",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
