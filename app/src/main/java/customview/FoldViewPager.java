package customview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.lang.reflect.Field;

import customif.FoldTransformer;

/**
 * Created by shanliang on 2018/5/2.
 */

public class FoldViewPager extends ViewPager {

    public FoldViewPager(Context context) {
        this(context, null);
    }

    public FoldViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }


    private void init() {

    }

    //    因为滑动过程中getCurrentItem不会变化，所以无法方便的在滑动过程中调整排序,在order为,这里重写，只是为了以防万一霸蛮要把mDrawingOrder设置为DRAW_ORDER_FORWARD
    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        Field mDrawingOrder = null;
        try {
            mDrawingOrder = ViewPager.class.getDeclaredField("mDrawingOrder");
            mDrawingOrder.setAccessible(true);
            int order = (int) mDrawingOrder.get(this);
            if (order != 2) {
                int currentItem = getCurrentItem();
                int[] sorts = new int[childCount];
                for (int index = 0; index <= currentItem; index++) {
                    sorts[index] = index;
                }
                sorts[currentItem] = 6;
                for (int index = 0; index < childCount - currentItem; index++) {
                    sorts[childCount - 1 - index] = index + currentItem;
                }
                int sort = sorts[i];
                return sort;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return super.getChildDrawingOrder(childCount, i);

    }
}
