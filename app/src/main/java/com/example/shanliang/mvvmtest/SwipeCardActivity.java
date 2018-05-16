package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import adapter.SwipeCardAdapter;
import adapter.UniversalAdapter;
import customview.BannerDotView;
import customview.CardConfig;
import entity.SwipeCardBean;

/**
 * Created by shanliang on 2018/4/11.
 */

public class SwipeCardActivity extends Activity {

    RecyclerView recyclerView;
    ArrayList<SwipeCardBean> list = new ArrayList<>();
    UniversalAdapter mAdapter;
    BannerDotView bannerDotView;


    private Handler uiHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Toast.makeText(SwipeCardActivity.this, "轮播", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_card_activity_layout);
        init();
        initData();
        initAdapter();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_swipe_card);
        bannerDotView = (BannerDotView) findViewById(R.id.bdw);
    }

    private void initData() {
        for(int i = 0; i < 5; i ++) {
            SwipeCardBean swipeCardBean = new SwipeCardBean();
            swipeCardBean.colorNum = i;
            list.add(swipeCardBean);
        }
        bannerDotView.initDot(6);
        bannerDotView.setIndex(1);
    }

    private void initAdapter() {
        SwipeCardLayoutManager swmanamger = new SwipeCardLayoutManager(this);
        recyclerView.setLayoutManager(swmanamger);
        mAdapter = new UniversalAdapter(list, this);
        recyclerView.setAdapter(mAdapter);
        CardConfig.initConfig(this);
        ItemTouchHelper.Callback callback=new SwipeCardCallBack(list,mAdapter,recyclerView);
        ItemTouchHelper helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        recyclerView.setVisibility(View.VISIBLE);



        initTimer();

    }

    private void initTimer() {
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 1;
                uiHandler.sendMessage(msg);
            }
        },3,5, TimeUnit.SECONDS);
    }
}
