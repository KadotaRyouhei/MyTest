package com.example.shanliang.mvvmtest;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.List;

import adapter.SwipeCardAdapter;
import adapter.UniversalAdapter;
import customview.CardConfig;
import entity.SwipeCardBean;

/**
 * Created by shanliang on 2018/4/11.
 */

public class SwipeCardCallBack extends ItemTouchHelper.SimpleCallback {
    private List<SwipeCardBean> mDatas;
    private UniversalAdapter adapter;
    private RecyclerView mRv;
    private static int OFFSET_X_ANIM = 26;

    public SwipeCardCallBack(List<SwipeCardBean> mDatas, UniversalAdapter adapter, RecyclerView mRv) {
        super(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
        );
        this.mDatas = mDatas;
        this.adapter = adapter;
        this.mRv = mRv;
    }



    public SwipeCardCallBack(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public SwipeCardCallBack() {
        /*
        * 即我们对哪些方向操作关心。如果我们关心用户向上拖动，可以将
         填充swipeDirs参数为LEFT | RIGHT 。0表示从不关心。
        * */
        super(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.UP |
                        ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
        );
    }

    @Override
    public boolean onMove(RecyclerView recyclerView,
                          RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        int addIndexEnd = mDatas.size() - 1; //末尾增加的位置

        if(direction == ItemTouchHelper.LEFT) {
            //当已经滑动删除了的时候会被回掉--删除数据，循环的效果

            if(addIndexEnd < 0) {
                addIndexEnd = 0;
            }
            SwipeCardBean remove = mDatas.remove(viewHolder.getLayoutPosition());
            mDatas.add(addIndexEnd, remove);
            adapter.notifyDataSetChanged();
        } else {
            //当已经滑动删除了的时候会被回掉--删除数据，循环的效果
            int removeIndex = mDatas.size() -1 - viewHolder.getLayoutPosition();
            SwipeCardBean remove = mDatas.remove(removeIndex);
            mDatas.add(0, remove);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        //监听话滑动的距离--控制动画的执行程度
        //灵界点
        double maxDistance = recyclerView.getWidth() * 0.5f;
        double distance = Math.sqrt(dX * dX);
        //动画执行的百分比
        double fraction = distance / maxDistance;
        if (fraction > 1) {
            fraction = 1;
        }
        int itemcount = recyclerView.getChildCount();
        int bottomPosition = itemcount -1;
        /*for (int i = bottomPosition; i >=0; i--) { //从1开始，只影响后三个
            //执行
            View view = recyclerView.getChildAt(i);
            //几个view层叠的效果，错开的效果--便宜动画+缩放动画
            //int level = itemcount - i - 1;
            int level = i;
            if (level <3 ) {
                if (level < CardConfig.MAX_SHOW_COUNT ) {
                    view.setTranslationY((float) (1 - CardConfig.TRANS_V_GAP * level + fraction * CardConfig.TRANS_V_GAP));
                    view.setScaleX((float) (1 - CardConfig.SCALE_GAP * level - fraction * CardConfig.SCALE_GAP));
                    view.setTranslationY((float) (1 - CardConfig.SCALE_GAP * level + fraction * CardConfig.SCALE_GAP));

                    view.setTranslationX((float) (CardConfig.TRANS_V_GAP * (level - 0.25 * fraction -(CardConfig.MAX_SHOW_COUNT - level) * fraction )));
                   view.setTranslationX((float) (- OFFSET_X_ANIM * fraction));
                    view.setTranslationX((float) ( OFFSET_X_ANIM * (3 - fraction * (1 + 0.2 * level) -level)));
                    view.setScaleX((float) (1 - CardConfig.SCALE_GAP * level + (i) * fraction * CardConfig.SCALE_GAP));
                    view.setScaleY((float) (1 - CardConfig.SCALE_GAP * level + (i * 0.75) * fraction * CardConfig.SCALE_GAP));
                }
            }


        }*/

    }

}
