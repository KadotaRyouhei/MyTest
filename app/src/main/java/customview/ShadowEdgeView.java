package customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.shanliang.mvvmtest.R;

/**
 * Created by shanliang on 2018/5/21.
 */

public class ShadowEdgeView extends RelativeLayout {

    private View contentView;

    public ShadowEdgeView(Context context) {
        this(context, null);
    }

    public ShadowEdgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init() {
        int childCount = getChildCount();
        if(childCount > 0) {
            View view = getChildAt(0);
            if(view != null) {
                view.setBackgroundResource(R.color.bg_drawable_blue);
            }
        }

    }


}
