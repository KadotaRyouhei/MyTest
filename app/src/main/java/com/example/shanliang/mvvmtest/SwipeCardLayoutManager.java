package com.example.shanliang.mvvmtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import customview.CardConfig;

/**
 * Created by shanliang on 2018/4/11.
 */

public class SwipeCardLayoutManager extends RecyclerView.LayoutManager {
    Context context;
    int TRANS_X_GAP;
    private static int OFFSET_X = 26;
    SwipeCardLayoutManager(Context context){
        TRANS_X_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,15,
                context.getResources().getDisplayMetrics());
    }
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        //1.如何实现层叠效果--cardView.layout(l,t,r,b)
        //2.如何让8个条目中的4个展示在RecylerView里面
        //1在布局layout之前，将所有的子View先全部detach掉，然后放到Scrap集合里面缓存。
        detachAndScrapAttachedViews(recycler);
        //2)只将最上面4个view添加到RecylerView容器里面
        int itemCount=getItemCount();//8个
        int bottomPosition;
        if(itemCount<4){
            bottomPosition=0;

        }else{
            bottomPosition = 3; //底层
        }
        for(int i= bottomPosition;i >= 0; i--){
            View view=recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view,0,0);
            int totalWidth = getWidth();
            int decorWidth = getDecoratedMeasuredWidth(view);
            int widthSpace= totalWidth - decorWidth;
            int heightSpace=getWidth()-getDecoratedMeasuredHeight(view);
            //摆放cardView
            layoutDecorated(view,
                    widthSpace/2,
                    heightSpace/2,
                    widthSpace/2+getDecoratedMeasuredWidth(view),
                    heightSpace/2+getDecoratedMeasuredHeight(view));
            //层叠效果--Scale+TranslationY
            //先放最下层
            //层级的位置关系1/2/3/4
            //int level=itemCount-i-1;
            int level = i;
            if(level>=0){
                if(level<CardConfig.MAX_SHOW_COUNT){
                    view.setTranslationX(OFFSET_X *level);
                    //view.setTranslationY(OFFSET_X *level);
                    //横向不缩小了
                    //view.setScaleX(1-CardConfig.SCALE_GAP*level);
                    view.setScaleY(1-CardConfig.SCALE_GAP *level);

                }
            }
        }



    }
}
