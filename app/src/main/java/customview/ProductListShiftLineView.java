package customview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

/**
 * Created by shanliang on 2018/3/16.
 */

public class ProductListShiftLineView extends LinearLayout {

    private Context mContext;
    private static final String TAG = "AutoTextViewLayout";
    private int textViewWidth;
    private boolean isCut = false;
    private int extraWidth = 0;
    private TextView textViewTop, textViewBottom;

    public ProductListShiftLineView(Context context) {
        super(context);
        mContext = context;
    }

    public ProductListShiftLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;
    }

    public void init(CharSequence text) {
        initView();
        initText(text);
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.product_list_shift_line_view,this);
        textViewTop = (TextView) view.findViewById(R.id.tv_corrector_top);
        textViewBottom = (TextView) view.findViewById(R.id.tv_corrector_bottom);
        int leftPadding = textViewTop.getCompoundPaddingLeft();
        int rightPadding = textViewTop.getCompoundPaddingRight();
        int width = mContext.getResources().getDisplayMetrics().widthPixels;
        textViewWidth = width - extraWidth - leftPadding - rightPadding;
        if(textViewWidth <=0) {
            setVisibility(GONE);
            return;
        }
    }

    private void initText(CharSequence text) {
        if(TextUtils.isEmpty(text)) {
            setVisibility(GONE);
            return;
        }
        Log.d(TAG, "TextView width " + textViewWidth);
        int sumWidth = 0;
        int strLength = text.length();
        Paint paint = textViewTop.getPaint();
        String strTotal = "";
        for (int index=0; index<strLength; index++) {
            // 计算每一个字符的宽度
            char c = text.charAt(index);
            strTotal += c;
            sumWidth = (int) paint.measureText(strTotal);
            if (sumWidth >= textViewWidth) {
                Log.d(TAG, "TextView shows #" + index + " char: " + text.subSequence(0, index));
                addText((text).subSequence(0,index -1),textViewTop);
                addText((text).subSequence(index - 1,strLength),textViewBottom);
                isCut = true;
                break;
            }
        }
        if(!isCut) {
            addText(text,textViewTop);
        }
    }

    private void addText(CharSequence text,TextView textView) {
        textView.setText(text);
        textView.setVisibility(VISIBLE);
    }

    public void setExtraWidth(float width ) {
        extraWidth = (int) convertDpToPixel(width);
    }

    // Dp转Px
    private float convertDpToPixel(float dp){
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

}
