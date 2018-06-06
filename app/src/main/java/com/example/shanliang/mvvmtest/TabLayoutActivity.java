package com.example.shanliang.mvvmtest;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import adapter.TabLayoutAdapter;
import adapter.TabLayoutViewPagerAdapter;
import customview.SmartPullableLayout;
import entity.TabEntity;

/**
 * Created by shanliang on 2018/6/5.
 */

public class TabLayoutActivity extends AppCompatActivity {

    private Context mContext;

    private TabLayout tlTop;

    private List<String> mEuropeanFood = new ArrayList<>();

    private List<String> mBuffet = new ArrayList<>();

    private List<String> mJapaneseCooking = new ArrayList<>();

    private List<String> mChaoshanChafingDish = new ArrayList<>();

    private List<String> mDatas = new ArrayList<>();

    private List<TabEntity> mTabs = new ArrayList<>();

    private List<View> mViewList = new ArrayList<>();

    private List<TabLayoutAdapter> mAdapterList = new ArrayList<>();

    private TabLayoutViewPagerAdapter mViewPagerAapter;

    private ViewPager mViewPager;

    private LayoutInflater inflater;

    /**
     * 屏幕宽度
     */
    private int screenWidth = 0;

    private int tabCount = 4;

    /**
     * 每一个tab宽度
     */
    private int tabWidth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout_activity);
        init();
        initTab();
        initData();
    }

    private void init() {
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mContext = TabLayoutActivity.this;
        inflater = LayoutInflater.from(mContext);
        tlTop = (TabLayout) findViewById(R.id.tl_top);
        mViewPager = (ViewPager) findViewById(R.id.vp_main);
    }

    private void initTab() {
        TabEntity tab1 = new TabEntity();
        tab1.tabName = "西餐";
        tab1.tabType = 1;
        tab1.viewPagerPosition = 0;
        mTabs.add(tab1);
        TabEntity tab2 = new TabEntity();
        tab2.tabName = "自助";
        tab2.tabType = 2;
        tab1.viewPagerPosition = 1;
        mTabs.add(tab2);
        TabEntity tab3 = new TabEntity();
        tab3.tabName = "日料";
        tab3.tabType = 3;
        tab1.viewPagerPosition = 2;
        mTabs.add(tab3);
        TabEntity tab4 = new TabEntity();
        tab4.tabName = "潮汕火锅";
        tab4.tabType = 4;
        tab1.viewPagerPosition = 3;
        mTabs.add(tab4);
        initScreenWidth();//初始化tab宽度
    }

    private void initTabWidth() {
        tlTop.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    Field mTabStripField = tlTop.getClass().getDeclaredField("mTabStrip");
                    mTabStripField.setAccessible(true);
                    LinearLayout mTabStrip = (LinearLayout) mTabStripField.get(tlTop);

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);



                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        int dpMargin = 20; //每个tab所需间距
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        if(width > 0 && tabWidth > width) {
                            dpMargin = (tabWidth - width) / 2;
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = dpMargin > 0 ? dpMargin : 0;
                        params.rightMargin = dpMargin > 0 ? dpMargin : 0;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    private void initScreenWidth() {
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        screenWidth = width;
        if(screenWidth > 0) {
            tabWidth = screenWidth / tabCount;
        }
    }




    private void initData() {
        for(int i = 0; i < 50; i ++) {
            String content = "点击获取" + (i + 1) + "颗圣晶石";
            mDatas.add(content);

            String contentE = "点击获取" + (i + 1) + "份牛排";
            mEuropeanFood.add(contentE);

            String contentB = "点击获取" + (i + 1) + "盘鸡翅";
            mBuffet.add(contentB);

            String contentJ = "点击获取" + (i + 1) + "份寿司";
            mJapaneseCooking.add(contentJ);

            String contentC = "点击获取" + (i + 1) + "盘吊龙";
            mChaoshanChafingDish.add(contentC);
        }

        addRecyclerViewAndAdapter(mEuropeanFood);
        addRecyclerViewAndAdapter(mBuffet);
        addRecyclerViewAndAdapter(mJapaneseCooking);
        addRecyclerViewAndAdapter(mChaoshanChafingDish);

        mViewPagerAapter = new TabLayoutViewPagerAdapter(mViewList, mAdapterList, mTabs);
        mViewPager.setAdapter(mViewPagerAapter);
        tlTop.setupWithViewPager(mViewPager);
        initTabWidth();
    }

    private void addRecyclerViewAndAdapter(List<String> datas) {
        View view = inflater.inflate(R.layout.tab_scroll_layout,null);
        SmartPullableLayout smartPullableLayout = view.findViewById(R.id.layout_pullable);//可以对下拉控件做设置
        RecyclerView recyclerView = view.findViewById(R.id.rcv_content);
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(llm);
        TabLayoutAdapter adapter = new TabLayoutAdapter(mContext);
        adapter.setData(datas);
        recyclerView.setAdapter(adapter);
        mAdapterList.add(adapter);
        mViewList.add(view);
    }


    private List<String> getFoodDatas(int foodType) {

        switch (foodType) {
            case 1:
                mDatas = mEuropeanFood;
                break;
            case 2:
                mDatas = mBuffet;
                break;
            case 3:
                mDatas = mJapaneseCooking;
                break;
            case 4:
                mDatas = mChaoshanChafingDish;
                break;
            default:
                mDatas = null;
                break;
        }
        return mDatas;
    }


}
