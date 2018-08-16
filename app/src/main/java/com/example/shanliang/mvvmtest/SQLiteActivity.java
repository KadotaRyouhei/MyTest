package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Utils.DBManager;
import Utils.LocalCupboard;
import model.Person;
import provider.PersonContentProvider;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/14
 */
public class SQLiteActivity extends Activity {

    private DBManager dm;

    private Button btnCreate;
    private Button btnInsert;
    private Button btnClear;
    private Button btnCheck;
    private Button btnShowData;
    private TextView tvCheck;

    private SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_layout);
        init();
    }

    private void init() {
        tvCheck = findViewById(R.id.tv_check);
        btnCreate = findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDataBase();
            }
        });

        btnInsert = findViewById(R.id.btn_insert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p4 = new Person("tom4",27,"cute");
                dm.insertData(p4);
            }
        });

        btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
            }
        });

        btnCheck= findViewById(R.id.btn_check);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
            }
        });

        btnShowData= findViewById(R.id.btn_show_list);
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
            }
        });

        //dm = new DBManager(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dm.closeDB();
    }

    private void createDataBase() {
        Person p1 = new Person("tom1",21,"cute");
        create(p1);
        Person p2 = new Person("tom2",22,"cute");
        create(p2);
        Person p3 = new Person("tom3",23,"cute");
        create(p3);
        Person p4 = new Person("tom4",24,"cute");
        create(p4);
        Person p5 = new Person("tom5",25,"cute");
        create(p5);
    }


    private void clearData() {
        getContentResolver().delete(PersonContentProvider.TRANSACTION_URI, null, null);
    }

    private void create(Person person) {
        ContentValues values = LocalCupboard.getInstance().withEntity(Person.class).toContentValues(person);
        getContentResolver().insert(PersonContentProvider.TRANSACTION_URI, values);
    };

    private void showData() {
        Intent intent = new Intent(this, ShowSQLiteDataActivity.class);
        startActivity(intent);
    }

    private void checkData() {
        List<Person> list = dm.findAllPerson();
        if(list != null) {
            if(list.size() > 0) {
                Person pF = list.get(0);
                tvCheck.setText(pF.name);
            } else {
                tvCheck.setText("no person");
            }
        }
    }



}
