package adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import customview.MostHotContentView;
import entity.HorizonItemListBean;

/**
 * Created by shanliang on 2018/5/3.
 */

public class MostHotViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<HorizonItemListBean> mDataList;

    public MostHotViewPagerAdapter(Context context, List<HorizonItemListBean> list) {
        mContext = context;
        mDataList = list;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mDataList == null ? 0 : 10000; //无限轮播
    }

    /**
     * 页面宽度所占ViewPager测量宽度的权重比例，默认为1
     */
    @Override
    public float getPageWidth(int position) {
        return (float) 0.8;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        MostHotContentView view = new MostHotContentView(mContext);
        view.initData(getListBean(position));
        container.addView(view);
        return view;
    }


    private HorizonItemListBean getListBean(int position) {
        HorizonItemListBean listBean = null;
        int realSize = mDataList == null ? 0 : mDataList.size();
        if(realSize > 0) {
            int index = position % realSize;
            if(index < realSize) {
                listBean = mDataList.get(index);
            }
        }
        return listBean;
    }
}
