package adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by shanliang on 2018/5/2.
 */

public class FoldViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<View> mDataList;

    public FoldViewPagerAdapter(Context context, List<View> list) {
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
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        container.addView(mDataList.get(position));


        return mDataList.get(position);
    }
}
