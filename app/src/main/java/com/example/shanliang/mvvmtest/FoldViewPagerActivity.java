package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.FoldViewPagerAdapter;
import customif.FoldTransformer;
import customview.FoldViewPager;

/**
 * Created by shanliang on 2018/5/2.
 */

public class FoldViewPagerActivity extends Activity {

    private List<View> viewList = new ArrayList<>();

    private FoldViewPager mViewPager;

    private FoldViewPagerAdapter foldViewPagerAdapter;


    private int[] imgIds = {
            R.drawable.img_001,
            R.drawable.img_002,
            R.drawable.img_003,
            R.drawable.img_004,
            R.drawable.img_005,
            R.drawable.img_006,
            R.drawable.img_007,
            R.drawable.img_008,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fold_view_pager_activity);
        init();
        initData();
    }

    private void init() {
        mViewPager = (FoldViewPager) findViewById(R.id.fvp_main);
        int width = mViewPager.getWidth();
        FoldTransformer foldTransformer = new FoldTransformer(width);
        mViewPager.setPageTransformer(true, foldTransformer);


    }

    private void initData() {
        int dataSize = imgIds.length;
        for(int i =0; i < dataSize; i ++) {
            View view = LayoutInflater.from(FoldViewPagerActivity.this).inflate(R.layout.fold_view_pager_item,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_fold);
            imageView.setImageResource(imgIds[0]);
            TextView textView = (TextView) view.findViewById(R.id.tv_fold);
            textView.setText("" + i);
            viewList.add(view);
        }

        foldViewPagerAdapter = new FoldViewPagerAdapter(FoldViewPagerActivity.this, viewList);
        mViewPager.setAdapter(foldViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
    }


}
