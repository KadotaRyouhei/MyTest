package customview;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.shanliang.mvvmtest.R;

/**
 * Created by shanliang on 2018/4/13.
 */

public class BannerDotView extends RelativeLayout {

    private Context mContext;
    private int totalNum = 0;
    private int index = 0;
    private LinearLayout llDot;

    public BannerDotView (Context context) {
        this(context, null);

    }

    public BannerDotView (Context context, AttributeSet attr) {
        super(context, attr);
        mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.banner_dot_view,this);
        llDot = (LinearLayout) view.findViewById(R.id.ll_dot_container);
    }

    public void initDot(int num) {
        totalNum = num;
        if(totalNum > 0) {
            for(int i =0; i < totalNum; i ++) {
                View view = View.inflate(mContext, R.layout.banner_dot_view_uncheck, null);
                llDot.addView(view);
            }
            llDot.requestLayout();
        }
    }

    public void setIndex(int index) {
        this.index = index;

        int size = llDot.getChildCount();
        for(int i =0;i<size; i ++) {
            View view = llDot.getChildAt(i);
            ImageView ivDot = (ImageView)view.findViewById(R.id.iv_dot);
            if(ivDot != null) {
                ivDot.setImageResource(i == index? R.mipmap.banner_dot_checked :R.mipmap.banner_dot_uncheck);
            }

        }
        llDot.requestLayout();
    }

}
