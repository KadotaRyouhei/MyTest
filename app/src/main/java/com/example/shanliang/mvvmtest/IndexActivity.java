package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.IndexAdapter;
import entity.IndexBean;

/**
 * Created by shanliang on 2018/4/20.
 */

public class IndexActivity extends Activity {

    private RecyclerView mRecyclerView;
    private List<IndexBean> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_activity);
        init();
        initData();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_index);
    }

    private void initData() {
        addIndex("GoRXJava2", RXJava2Activity.class);
        addIndex("GoAlgorithm", AlgorithmActivity.class);
        addIndex("GoNewCategory", NewCategoryActivity.class);
        addIndex("GoTabActivity", TabLayoutActivity.class);
        addIndex("GoAACActivity", AACActivity.class);
        addIndex("GoShadowEdge", ShadowEdgeActivity.class);
        addIndex("GoShadowDrawable", ShadowDrawableActivity.class);
        addIndex("GoMostHot", MostHotActivity.class);
        addIndex("GoHorizonViewPager", HorizonViewPagerActivity.class);
        addIndex("GoNormalViewPager", NormalViewPagerActivity.class);
        addIndex("GoFoldViewPager", FoldViewPagerActivity.class);
        addIndex("GoPullableLayout", PullableLayoutActivity.class);
        addIndex("GoHotCategory", HotCategoryActivity.class);
        addIndex("GoFirst", FirstActivity.class);
        addIndex("GoDataBinding", DataBindingActivity.class);
        addIndex("GoDataBindingFragment", DataBindingFragmentActivity.class);
        addIndex("GoRecycler", RecyclerViewActivity.class);
        addIndex("GoRXJava", RXJavaActivity.class);
        addIndex("GoAutoText", AutoTextViewActivity.class);
        addIndex("GoKakiller", KillAssSecondActivity.class);
        addIndex("GoCarView", CardViewPagerActivity.class);
        addIndex("GoSwipeCard", SwipeCardActivity.class);
        addIndex("GoReflection", ReflectionTestActivity.class);


        IndexAdapter indexAdapter = new IndexAdapter(IndexActivity.this, mDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(IndexActivity.this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(indexAdapter);

    }

    private void addIndex(String name, Class destClass) {
        IndexBean indexBean = new IndexBean();
        indexBean.name = name;
        indexBean.destClass = destClass;
        if(mDataList != null) {
            mDataList.add(indexBean);
        }
    }

}
