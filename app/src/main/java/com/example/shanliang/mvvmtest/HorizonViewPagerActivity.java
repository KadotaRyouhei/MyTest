package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import adapter.MostHotViewPagerAdapter;
import entity.HorizonItemBean;
import entity.HorizonItemListBean;

/**
 * Created by shanliang on 2018/5/3.
 */

public class HorizonViewPagerActivity  extends Activity {

    private ViewPager mViewPager;
    private List<HorizonItemBean> oriList = new ArrayList<>();
    private List<HorizonItemListBean> targetList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizon_view_pager_activity);
        init();
        initData();
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.vp_horizon);
    }

    private void initData() {
        for(int i = 0; i < 15; i ++) {
            HorizonItemBean itemBean = new HorizonItemBean();
            itemBean.name = "第" + i + "瓶牛奶";
            oriList.add(itemBean);
        }
        createShowData();
        MostHotViewPagerAdapter pagerAdapter = new MostHotViewPagerAdapter(HorizonViewPagerActivity.this, targetList);
        mViewPager.setAdapter(pagerAdapter);
    }


    private void createShowData() {
        int count = oriList.size();
        HorizonItemListBean listBean = null;
        for(int i = 0; i < count; i ++) {
            if(i % 4 == 0) {
                listBean = new HorizonItemListBean();
            }
            if(listBean != null) {
                listBean.list.add(oriList.get(i));
                if(i % 4 == 3 || i == count -1) {
                    targetList.add(listBean);
                }
            }
        }
    }


}
