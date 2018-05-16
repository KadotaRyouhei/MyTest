package holder;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.shanliang.mvvmtest.HorizonViewPagerActivity;
import com.example.shanliang.mvvmtest.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MostHotViewPagerAdapter;
import entity.HorizonItemBean;
import entity.HorizonItemListBean;

/**
 * Created by shanliang on 2018/5/4.
 */

public class MostHotHolder extends RecyclerView.ViewHolder {

    private ViewPager viewPager;
    private List<HorizonItemBean> oriList = new ArrayList<>();
    private List<HorizonItemListBean> targetList = new ArrayList<>();

    public MostHotHolder(View view) {
        super(view);
        viewPager = (ViewPager) view.findViewById(R.id.vp_most_hot);
    }

    public void initData(Context context) {
        for(int i = 0; i < 15; i ++) {
            HorizonItemBean itemBean = new HorizonItemBean();
            itemBean.name = "第" + i + "瓶牛奶";
            oriList.add(itemBean);
        }
        createShowData();
        MostHotViewPagerAdapter pagerAdapter = new MostHotViewPagerAdapter(context, targetList);
        viewPager.setAdapter(pagerAdapter);
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
