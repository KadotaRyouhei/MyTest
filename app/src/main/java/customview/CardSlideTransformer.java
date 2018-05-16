package customview;

import android.content.Context;
import android.view.View;

import Utils.DPIUtil;

/**
 * Created by shanliang on 2018/4/10.
 */

public class CardSlideTransformer extends BaseTransformer {

    private int showCardNum; // 应该显示的卡片数,取wareCount与默认CardNum的最小值

    private int width = 0;
    private int height = 0;
    private DPIUtil mDPIUtil;

    public CardSlideTransformer(Context context, int wareCount) {
        mDPIUtil = new DPIUtil(context);
        //showCardNum = wareCount <= CardConfig.CARD_NUM ? wareCount : CardConfig.CARD_NUM;
    }

    @Override
    protected void onTransform(View page, float position) {
//        System.out.println("onTranform:" + position);

        /*if (width == 0 && page.getWidth() != 0) {
            width = page.getWidth();
        }
        if (height == 0 && page.getHeight() != 0) {
            height = page.getHeight();
        }
        if (position <= 0f) {
            page.setTranslationX(0f);
            page.setScaleX(1f);
            page.setScaleY(1f);
            page.setAlpha(1.0f);
            page.setClickable(true);
        } else if (position < showCardNum) {
            float scaleX = (float) (width - mDPIUtil.dip2px(CardConfig.DELTA_SPACE * position)) / (float) (width); // 卡片拖动的时候,底部卡片缩放的比例
            float scaleY = (float) (height - mDPIUtil.dip2px(2 * CardConfig.DELTA_Y_SPACE * position)) / (float) (height); // Y方向的缩放比例
            page.setClickable(false);
            page.setAlpha(1.0f - (position * CardConfig.ALPHA_NUM));
            page.setPivotX(width / 2f);
            page.setPivotY(height / 2f);
            page.setScaleX(scaleX);
            page.setScaleY(scaleY);
            page.setTranslationX(-width * position + (1 - scaleX) /2 * width + mDPIUtil.dip2px(CardConfig.DELTA_SPACE) * position);
        }*/
    }
}
