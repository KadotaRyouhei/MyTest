package com.example.shanliang.mvvmtest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import Utils.DPIUtil;
import adapter.CardViewAdapter;
import customview.CardConfig;
import customview.CardSlideTransformer;

/**
 * Created by shanliang on 2018/4/10.
 */

public class CardViewPagerActivity extends Activity {

    ViewPager vpContent;
    CardViewAdapter adapter;
    List<View> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_page_activity);
        init();
        initData();
        initAdapter();
    }

    private void init() {
        vpContent = (ViewPager) findViewById(R.id.vp_content);
    }

    private void initData() {
        for(int i =0; i < 10; i ++) {
            View view = getLayoutInflater().inflate(R.layout.card_item, null);
            int type = i%3;
            if(type == 0) {
                view.findViewById(R.id.v_card_item).setBackgroundResource(R.color.colorAccent);
            } else if(type == 1) {
                view.findViewById(R.id.v_card_item).setBackgroundResource(R.color.colorPrimary);
            } else {
                view.findViewById(R.id.v_card_item).setBackgroundResource(R.color.colorPrimaryDark);
            }
            dataList.add(view);
        }
    }

    private void initAdapter() {
        adapter = new CardViewAdapter(CardViewPagerActivity.this, dataList);
        vpContent.setAdapter(adapter);
        vpContent.setCurrentItem(100 * dataList.size(), false);
        vpContent.setOffscreenPageLimit(3);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) vpContent.getLayoutParams();
        params.leftMargin = -width;
        params.rightMargin = width;
        vpContent.setLayoutParams(params);
        vpContent.setPageTransformer(true, new CardSlideTransformer(CardViewPagerActivity.this,
                dataList.size()));
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(vpContent, "x", 0, 0),
                ObjectAnimator.ofFloat(vpContent, "alpha", 0.0f, 1.0f)

        );
        set.setDuration(450).start();
    }

}
