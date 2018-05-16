package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.MyAdapter;
import entity.People;

/**
 * Created by shanliang on 2018/3/9.
 */

public class RecyclerViewActivity extends Activity {

    private RecyclerView recyclerView;
    private ArrayList<People> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_recyclerview);
        init();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL,false));

        mData = new ArrayList<People>() {
            {
               for(int i = 0; i < 10; i ++) {
                   add(new People("neko",i + 1,true));
               }
            }
        };

        recyclerView.setAdapter(new MyAdapter(this,mData));

    }
}
