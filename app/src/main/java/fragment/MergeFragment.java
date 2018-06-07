package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import Utils.DPIUtil;
import Utils.DensityUtil;
import adapter.TabLayoutAdapter;
import adapter.TabLayoutViewPagerAdapter;
import customview.SmartPullableLayout;
import entity.TabEntity;

/**
 * Created by shanliang on 2018/6/7.
 */

public class MergeFragment extends Fragment {

    private Context mContext;

    private FragmentActivity mActivity;

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

    private View rootView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_layout_activity,container,false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        initTab();
        initData();
    }

    private void init() {
        mActivity = getActivity();
        mContext = mActivity;
        inflater = LayoutInflater.from(mContext);
    }

    private void initView(View view) {
        tlTop = (TabLayout) view.findViewById(R.id.tl_top);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_main);
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

    public void setActivity(AppCompatActivity activity) {

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
                        mTextView.setTextSize(DensityUtil.dip2px(mActivity, 16));
                        mTextView.setTextColor(mActivity.getResources().getColor(R.color.colorPrimary, null));
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
        WindowManager manager = mActivity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        screenWidth = width;
        if(screenWidth > 0) {
            tabWidth = (screenWidth - DensityUtil.dip2px(mActivity, 90)) / tabCount;
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



}
