package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MostHotAdapter;
import fragment.MostHotFragment;

/**
 * Created by shanliang on 2018/5/4.
 */

public class MostHotActivity extends Activity {

    private RecyclerView recyclerView;
    private MostHotAdapter adapter;
    private List<String> dataList = new ArrayList<>();
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.most_hot_activity);
        init();
        initFragment();
        //initData();
    }

    private void init() {
        //recyclerView = (RecyclerView) findViewById(R.id.rv_most_hot);
        frameLayout = (FrameLayout) findViewById(R.id.fl_container);

    }

    private void initFragment() {
        FragmentManager fm = getFragmentManager();                 //获取FragmentManager
        FragmentTransaction ft = fm.beginTransaction();            //开启一个事务
        MostHotFragment mostHotFragment = new MostHotFragment();
        mostHotFragment.setmContext(MostHotActivity.this);
        ft.replace(R.id.fl_container, mostHotFragment).commit();
    }

    private void initData() {
        for(int i = 0; i < 10; i ++) {
            dataList.add("第" + i + "份鳗鱼饭");
        }
        adapter = new MostHotAdapter(MostHotActivity.this, dataList);
        LinearLayoutManager llm = new LinearLayoutManager(MostHotActivity.this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

}
