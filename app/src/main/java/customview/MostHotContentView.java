package customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.shanliang.mvvmtest.R;

import java.util.List;

import entity.HorizonItemBean;
import entity.HorizonItemListBean;

/**
 * Created by shanliang on 2018/5/3.
 */

public class MostHotContentView extends LinearLayout {

    private Context mContext;
    private MostHotItemView itemOne;
    private MostHotItemView itemTwo;
    private MostHotItemView itemThree;
    private MostHotItemView itemFour;
    private MostHotItemView[] items = new MostHotItemView[4];

    public MostHotContentView(Context context) {
        this(context, null);
    }

    public MostHotContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.most_hot_item_content, this, true);
        itemOne = (MostHotItemView) view.findViewById(R.id.hciv_one);
        itemTwo = (MostHotItemView) view.findViewById(R.id.hciv_two);
        itemThree = (MostHotItemView) view.findViewById(R.id.hciv_three);
        itemFour = (MostHotItemView) view.findViewById(R.id.hciv_four);
        items[0] = itemOne;
        items[1] = itemTwo;
        items[2] = itemThree;
        items[3] = itemFour;
    }

    public void initData(HorizonItemListBean listBean) {
        if(listBean != null && listBean.list != null && listBean.list.size() > 0) {
            clearItems();
            List<HorizonItemBean> list = listBean.list;
            if(list != null && list.size() > 0) {
                for(int i = 0, count = list.size(); i < count; i ++) {
                    if(i < 4) {
                        HorizonItemBean itemBean = list.get(i);
                        items[i].initData(itemBean);
                        items[i].setVisibility(VISIBLE);
                    }
                }
            }
        }
    }

    private void clearItems() {
        for(int i =0; i < 4; i ++) {
            if(items[i].getVisibility() != INVISIBLE) {
                items[i].setVisibility(INVISIBLE);
            }
        }
    }



}
