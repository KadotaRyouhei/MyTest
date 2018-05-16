package customview;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by shanliang on 2018/4/10.
 */

public class CardConfig {
    //屏幕最对同时显示几个item
    public static int  MAX_SHOW_COUNT=4;
    //没一级Scale相差0.05f，translation相差7dp左右
    public static  float SCALE_GAP;
    public static int TRANS_V_GAP;

    public static void initConfig(Context context){
        MAX_SHOW_COUNT=4;
        SCALE_GAP=0.1f; //UI图中给出缩放比例上下高度为每一层十分之一
        TRANS_V_GAP=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,15,context.getResources().getDisplayMetrics());
    }
}
