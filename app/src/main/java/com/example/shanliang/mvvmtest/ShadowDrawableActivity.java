package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;

import customview.ShadowDrawable;

/**
 * Created by shanliang on 2018/5/18.
 */

public class ShadowDrawableActivity extends Activity {

    private LinearLayout llContainer, llContainer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shadow_drawable_activity);
        init();
    }

    private void init() {
        llContainer = (LinearLayout) findViewById(R.id.ll_container);
        llContainer2 = (LinearLayout) findViewById(R.id.ll_container2);
        /*ShadowDrawable.setShadowDrawable(llContainer, Color.parseColor("#3D5AFE"), 0,
                Color.parseColor("#f0000000"),
                20, 0, 10);*/

        ShadowDrawable.setShadowDrawable(llContainer2, Color.parseColor("#3D5AFE"), 0,
                Color.parseColor("#f0000000"),
                20, 0, 10);
    }


    public static void setShadowDrawable(View view, int shapeRadius, int shadowColor, int shadowRadius, int offsetX, int offsetY) {
        ShadowDrawable drawable = new ShadowDrawable.Builder()
                .setShapeRadius(shapeRadius)
                .setShadowColor(shadowColor)
                .setShadowRadius(shadowRadius)
                .setOffsetX(offsetX)
                .setOffsetY(offsetY)
                .builder();
        view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        ViewCompat.setBackground(view, drawable);
    }


}
