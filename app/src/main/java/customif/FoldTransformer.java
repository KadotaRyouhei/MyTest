package customif;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by shanliang on 2018/5/2.
 */

public class FoldTransformer implements ViewPager.PageTransformer {

    private int offsetWidth;

    public FoldTransformer(int width) {
        offsetWidth = width;
    }

    public void transformPage(View page, float position) {
//执行缩放
        float scaleFactor = 0.05f;
        float scaleFinal = 0.9f - scaleFactor * position;
        //page.setScaleX(scaleFinal);
        page.setScaleY(scaleFinal);
        int width = page.getWidth();
        page.setTranslationX((-position) * (width - 40));
    }


    private float getTranslationX(int width, float scaleFactor) {
        return 0;
    }

}
