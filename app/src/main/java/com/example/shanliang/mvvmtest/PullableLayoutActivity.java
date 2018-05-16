package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.CategoryFirstAdapter;
import customview.SmartPullableLayout;
import model.CategoryEntity;

/**
 * Created by shanliang on 2018/4/23.
 */

public class PullableLayoutActivity extends Activity {

    private static final int ON_REFRESH = 1;
    private static final int ON_LOAD_MORE = 2;

    private int selectIndex = 0;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ON_REFRESH:
                    //listData.add(0, "这是全新的数据");
                    //mLvAdapter.notifyDataSetChanged();
                    mPullableLayout.stopPullBehavior();
                    break;
                case ON_LOAD_MORE:
                    //listData.add("这是加载出来的数据");
                    if(currentFirstIndex + 1 < listDataLeft.size()) {
                        currentFirstIndex += 1;
                        onNext(currentFirstIndex);
                        if(currentFirstIndex + 1 < listDataLeft.size()) {
                           mPullableLayout.setmCategoryEntity(listDataLeft.get(currentFirstIndex));
                        } else {
                            mPullableLayout.setmCategoryEntity(null);
                        }
                    }
                    //mLvAdapter.notifyDataSetChanged();
                    mPullableLayout.stopPullBehavior();
                    break;
            }
        }
    };

    private SmartPullableLayout mPullableLayout;
    private ListView lvContentRight, lvContentLeft;
    private ArrayList<CategoryEntity> listDataRight;
    private ArrayList<CategoryEntity> listDataLeft;
    private CategoryFirstAdapter mLvAdapterRight;
    private CategoryFirstAdapter mLvAdapterLeft;
    private CategoryFirstAdapter.CategoryFirstListener leftListener;
    private CategoryFirstAdapter.CategoryFirstListener rightListener;
    private CategoryEntity mCurrentFirstCategory;
    private int currentFirstIndex = 0;



    private void onNext(int position) {
        mLvAdapterLeft.setCurrentItem(position);
        mLvAdapterRight.setCurrentItem(position);
        mLvAdapterLeft.notifyDataSetChanged();
        mLvAdapterRight.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pullable_layout_activity);
        mPullableLayout = (SmartPullableLayout) findViewById(R.id.layout_pullable);
        lvContentRight = (ListView) findViewById(R.id.lv_content_right);
        lvContentLeft = (ListView) findViewById(R.id.lv_content_left);
        listDataLeft = new ArrayList<>();
        listDataRight = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            CategoryEntity ce = new CategoryEntity();
            ce.cName = "这是第" + i + "条数据";
            ce.cIndex = i;
            listDataRight.add(ce);
            CategoryEntity ceL = new CategoryEntity();
            ceL.cIndex = i;
            ceL.cName = "第" + i + "项";
            listDataLeft.add(ceL);
        }
        mLvAdapterLeft = new CategoryFirstAdapter(listDataLeft,this);
        mCurrentFirstCategory = listDataLeft.get(0);
        if(1 < listDataLeft.size()) {
            CategoryEntity ce = listDataLeft.get(1);
            mPullableLayout.setmCategoryEntity(ce);
        } else {
            mPullableLayout.setmCategoryEntity(null);
        }
        mLvAdapterRight = new CategoryFirstAdapter(listDataRight,this);
        mLvAdapterLeft.setListener(new CategoryFirstAdapter.CategoryFirstListener() {
            @Override
            public void onClick(int position) {
                currentFirstIndex = position;
                if(currentFirstIndex + 1 < listDataLeft.size()) {
                    mPullableLayout.setmCategoryEntity(listDataLeft.get(currentFirstIndex));
                } else {
                    mPullableLayout.setmCategoryEntity(null);
                }
                onNext(position);
            }
        });
        lvContentLeft.setAdapter(mLvAdapterLeft);
        lvContentRight.setAdapter(mLvAdapterRight);


        mPullableLayout.setOnPullListener(new SmartPullableLayout.OnPullListener() {
            @Override
            public void onPullDown() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(ON_REFRESH);
                    }
                }).start();
            }

            @Override
            public void onPullUp() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(ON_LOAD_MORE);
                    }
                }).start();
            }

        });
    }

}
