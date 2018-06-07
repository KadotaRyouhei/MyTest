package com.example.shanliang.mvvmtest;


import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.CategoryLeftAdapter;
import baseinterface.FragmentCreator;
import commoninterface.LeftClickListener;
import entity.CategoryLeftBean;
import fragment.DataBindingFragment;
import fragment.MergeFragment;

/**
 * Created by shanliang on 2018/6/6.
 */

public class NewCategoryActivity extends AppCompatActivity {

    private Context mContext;

    private LayoutInflater inflater;

    private RecyclerView mRecyclerViewLeft;

    private CategoryLeftAdapter mLeftAdapter;

    private List<CategoryLeftBean> mDataLeft = new ArrayList<>();

    private FrameLayout flContainer;

    private LeftClickListener leftClickListener;

    private View.OnClickListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_category_activity);
        init();
        initListener();
        initData();
    }

    private void init() {
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mContext = NewCategoryActivity.this;
        inflater = LayoutInflater.from(mContext);
        flContainer = (FrameLayout) findViewById(R.id.fl_container);
        mRecyclerViewLeft = (RecyclerView) findViewById(R.id.rcv_left);
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        mRecyclerViewLeft.setLayoutManager(llm);

    }

    private void initListener() {
        leftClickListener = new LeftClickListener() {
            @Override
            public void getRightData(int type) {
                resetRightFragment(type);
            }
        };

        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }


    private void initData() {
        initLeftData();
        resetRightFragment(0);
    }

    private void initLeftData() {
        for(int i = 0; i < 30; i ++) {
            CategoryLeftBean categoryLeftBean = new CategoryLeftBean();
            categoryLeftBean.name = "第" + (i + 1) + "天";
            mDataLeft.add(categoryLeftBean);
        }
        mLeftAdapter = new CategoryLeftAdapter(mContext);
        mLeftAdapter.setLeftClickListener(leftClickListener);
        mLeftAdapter.setDataList(mDataLeft);
        mRecyclerViewLeft.setAdapter(mLeftAdapter);
    }

    private void resetRightFragment(int type) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, FragmentCreator.getFragment(type)).commit();
    }
}
