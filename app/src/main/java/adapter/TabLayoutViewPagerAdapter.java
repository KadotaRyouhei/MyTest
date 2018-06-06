package adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import commoninterface.TabLayoutIF;
import entity.TabEntity;

/**
 * Created by shanliang on 2018/6/5.
 */

public class TabLayoutViewPagerAdapter extends PagerAdapter {


    private List<View> mViewList;

    private List<TabLayoutAdapter> mAdapterList;

    private List<TabEntity> mTabs;

    private TabLayoutIF tabLayoutIF;

    public TabLayoutViewPagerAdapter(List<View> mViewList, List<TabLayoutAdapter> adapterList, List<TabEntity> tabs) {
        this.mViewList = mViewList;
        mAdapterList = adapterList;
        mTabs = tabs;
    }


    public void setTabLayoutIF(TabLayoutIF tabLayoutIF) {
        this.tabLayoutIF = tabLayoutIF;
    }


    @Override
    public int getCount() {//必须实现
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {//必须实现
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//必须实现，实例化
        TabLayoutAdapter tabLayoutAdapter = mAdapterList.get(position);
        if(tabLayoutIF != null) {
            tabLayoutAdapter.setData(tabLayoutIF.getData(position));
        }
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//必须实现，销毁
        container.removeView(mViewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs.get(position).tabName;
    }


}
