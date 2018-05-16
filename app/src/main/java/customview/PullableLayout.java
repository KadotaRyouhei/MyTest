package customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

import javax.xml.transform.Templates;

/**
 * Created by shanliang on 2018/4/23.
 */

public class PullableLayout extends ViewGroup {

    private View mHeader, mFooter;
    private TextView tvPullHeader;

    public PullableLayout (Context context) {
        super(context);
    }

    public PullableLayout (Context context, AttributeSet attr) {
        super(context, attr);
        mHeader = LayoutInflater.from(context).inflate(R.layout.pullable_header, null);
        mFooter = LayoutInflater.from(context).inflate(R.layout.pullable_footer, null);
        tvPullHeader = (TextView) mHeader.findViewById(R.id.tv_pullable_header);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mHeader.setLayoutParams(params);
        mFooter.setLayoutParams(params);
        addView(mHeader);
        addView(mFooter);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 测量
        for (int i = 0; i < getChildCount(); i++){
            View child = getChildAt(i);
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
        }
    }

    private int mLayoutContentHeight;
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mLayoutContentHeight = 0;
        // 置位
        for (int i = 0; i < getChildCount(); i++){
            View child = getChildAt(i);
            if (child == mHeader) { // 头视图隐藏在顶端
                child.layout(0, 0 - child.getMeasuredHeight(), child.getMeasuredWidth(), 0);
            } else if (child == mFooter) { // 尾视图隐藏在layout所有内容视图之后
                child.layout(0, mLayoutContentHeight, child.getMeasuredWidth(), mLayoutContentHeight + child.getMeasuredHeight());
            } else { // 内容视图根据定义(插入)顺序,按由上到下的顺序在垂直方向进行排列
                child.layout(0, mLayoutContentHeight, child.getMeasuredWidth(), mLayoutContentHeight + child.getMeasuredHeight());
                mLayoutContentHeight += child.getMeasuredHeight();
            }
        }
    }

    private int mLastMoveY;
    private int effectiveScrollY = 200;
    private int maxEffectiveScrollY = 500;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastMoveY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int dy = mLastMoveY - y;
                //scrollBy(0, dy);

                if(dy < 0) {
                    if(Math.abs(getScaleY()) <= maxEffectiveScrollY) {
                        scrollBy(0, dy);
                        if(Math.abs(getScaleY()) >= effectiveScrollY) {
                            tvPullHeader.setText("松开刷新");
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if(Math.abs(getScrollY()) >= effectiveScrollY){
                    //mLayoutScroller.startScroll(0, getScrollY(), 0, -(getScrollY() + effectiveScrollY));
                    tvPullHeader.setVisibility(View.GONE);
                    //pbPullHeader.setVisibility(View.VISIBLE);
                }else{
                    //mLayoutScroller.startScroll(0, getScrollY(), 0, -getScrollY());
                }
                break;
        }

        mLastMoveY = y;
        return true;
    }






}
