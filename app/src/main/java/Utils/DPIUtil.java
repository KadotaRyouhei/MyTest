package Utils;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by shanliang on 2018/4/10.
 */

public class DPIUtil {
    private  float mDensity = 160.0F;
    private  Display defaultDisplay;
    private  Point outSize = null;
    private  Context mContext;

    public DPIUtil(Context context) {
        mContext = context;
    }

    public  void setDensity(float density) {
        mDensity = density;

    }

    public  float getDensity() {
        return mDensity;
    }

    public  Display getDefaultDisplay() {
        if(null == defaultDisplay) {
            //WindowManager systemService = (WindowManager)mContext.getApplicationContext().getSystemService("window");
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            defaultDisplay = wm.getDefaultDisplay();
        }

        return defaultDisplay;
    }

    public  int percentWidth(float percent) {
        return (int)((float)getWidth() * percent);
    }

    public  int percentHeight(float percent) {
        return (int)((float)getHeight() * percent);
    }

    public int dip2px(float dipValue) {
        return (int)(dipValue * mDensity + 0.5F);
    }

    public  int px2dip(float pxValue) {
        return (int)(pxValue / mDensity + 0.5F);
    }

    public  int getWidth() {
        if(outSize == null) {
            Class var0 = DPIUtil.class;
            synchronized(DPIUtil.class) {
                if(outSize == null) {
                    getPxSize();
                }
            }
        }

        return outSize.x;
    }

    public  int getHeight() {
        Display display = getDefaultDisplay();
        Point outSize = new Point();
        display.getSize(outSize);
        return outSize.y;
    }

    public  int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(pxValue / fontScale + 0.5F);
    }

    public  int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)((spValue - 0.5F) * fontScale);
    }

    public  int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5F);
    }

    public  int getWidthByDesignValue(int nDesignValue, int nDesignScreenWidth) {
        return (int)((float)(getWidth() * nDesignValue) / (float)nDesignScreenWidth + 0.5F);
    }

    public  int getWidthByDesignValue720(int nDesignValue) {
        return getWidthByDesignValue(nDesignValue, 720);
    }

    public  int getWidthByDesignValue750(int nDesignValue) {
        return getWidthByDesignValue(nDesignValue, 750);
    }

    public  void getPxSize() {
        Display display = getDefaultDisplay();
        outSize = new Point();
        display.getSize(outSize);
    }
}

