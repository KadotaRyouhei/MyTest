package adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shanliang.mvvmtest.R;

import java.util.List;

/**
 * Created by shanliang on 2018/4/10.
 */

public class CardViewAdapter extends PagerAdapter{

    private List<View> mViewList;
    private Context mContext;

    public CardViewAdapter(Context context, List<View> mViewList) {
        mContext = context;
        this.mViewList = mViewList;
    }

    @Override
    public int getCount() {//必须实现
        if (mViewList == null) {
            return 0;
        } else if (mViewList.size() <= 1) {
            return 1;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public View getView(Context context, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_item,null);
        //View view = mContext.inflate(context, R.layout.lib_search_productlist_viewpager_item, null);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {//必须实现
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//必须实现，实例化
        int index = computePosition(position);
        View view = getView(mContext, index);
        setBackGround(view, index);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//必须实现，销毁
        container.removeView((View) object);
    }

    private int computePosition(int position) {
        return position % mViewList.size();
    }

    private void setBackGround(View view, int position) {
        int type = position%3;
        if(type == 0) {
            view.findViewById(R.id.v_card_item).setBackgroundResource(R.color.colorAccent);
        } else if(type == 1) {
            view.findViewById(R.id.v_card_item).setBackgroundResource(R.color.colorPrimary);
        } else {
            view.findViewById(R.id.v_card_item).setBackgroundResource(R.color.colorPrimaryDark);
        }
    }




}
