package customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.shanliang.mvvmtest.R;

/**
 * Created by shanliang on 2018/5/21.
 */

public class ShadowView extends View {

    public ShadowView(Context context) {
        super(context);
    }

    public ShadowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setShadowLayer(10f, 0, 0, R.color.bg_drawable_blue);
    }
}
