package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Utils.DBManager;
import model.Person;

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
    private Button btnCheck;
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

            }
        });

        btnCheck= findViewById(R.id.btn_check);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
            }
        });

        dm = new DBManager(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dm.closeDB();
    }

    private void createDataBase() {
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("tom1",21,"cute");
        Person p2 = new Person("tom2",21,"cute");
        Person p3 = new Person("tom3",21,"cute");
        Person p4 = new Person("tom4",21,"cute");
        Person p5 = new Person("tom5",21,"cute");
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        dm.add(people);
    }

    private void insertData() {

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
