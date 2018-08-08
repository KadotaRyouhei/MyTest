package customview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/8
 */
public class AutoFitTextView extends RelativeLayout {


    private static final String TAG = "AutoFitText";

    /**
     * 上下文
     */
    private Context mContext;

    /**
     * 展示内容文本
     */
    private TextView tvAutoFitTextView;

    /**
     * 最终展示文案
     */
    private String resultText;

    /**
     * 文本可展示宽度
     */
    private int textViewWidth;

    /**
     * 额外宽度
     */
    private int extraWidth = 0;


    /**
     * 构造方法
     * @param context 上下文
     */
    public AutoFitTextView(Context context) {
        this(context, null);
    }

    /**
     * 构造方法
     * @param context 上下文
     * @param attributeSet 属性
     */
    public AutoFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        View view = View.inflate(mContext, R.layout.auto_fit_text_layout,this);
        tvAutoFitTextView = (TextView) view.findViewById(R.id.tv_auto_fit);
    }

    /**
     * 初始化文案
     * @param text 内容
     */
    public void initText(CharSequence text) {
        if(TextUtils.isEmpty(text)) {
            setVisibility(GONE);
            return;
        }
        int leftPadding = tvAutoFitTextView.getCompoundPaddingLeft();
        int rightPadding = tvAutoFitTextView.getCompoundPaddingRight();
        int width = mContext.getResources().getDisplayMetrics().widthPixels;
        textViewWidth = width - extraWidth - leftPadding - rightPadding;
        if(textViewWidth <=0) {
            setVisibility(GONE);
            return;
        }
        Log.d(TAG, "TextView width " + textViewWidth);
        int sumWidth = 0;
        int strLength = text.length();
        resultText = String.valueOf(text);
        Paint paint = tvAutoFitTextView.getPaint();
        String strTotal = "";
        for (int index=0; index<strLength; index++) {
            // 计算每一个字符的宽度
            char c = text.charAt(index);
            strTotal += c;
            sumWidth = (int) paint.measureText(strTotal);
            if (sumWidth >= textViewWidth) {
                Log.d(TAG, "TextView shows #" + index + " char: " + text.subSequence(0, index));
                CharSequence csLineOne = text.subSequence(0,index -1);
                CharSequence csLineTwo = text.subSequence(index - 1,strLength);
                resultText = csLineOne + " " + csLineTwo;
                break;
            }
        }

        tvAutoFitTextView.setText(resultText);

    }

    /**
     * 设置额外宽度
     * @param width 宽度
     */
    public void setExtraWidth(float width ) {
        extraWidth = (int) convertDpToPixel(width);
    }


    /**
     * dp转px
     * @param dp 长度
     * @return 返回
     */
    private float convertDpToPixel(float dp){
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

}
