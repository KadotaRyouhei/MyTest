package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import customview.ShadowEdgeView;

/**
 * Created by shanliang on 2018/5/21.
 */

public class ShadowEdgeActivity extends Activity {

    private ShadowEdgeView shadowEdgeView;
    private View vPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shadow_edge_activity);
        init();
    }

    private void init(){
        shadowEdgeView = (ShadowEdgeView) findViewById(R.id.sev_content);
        shadowEdgeView.init();
        vPaint = (View) findViewById(R.id.v_paint);

        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.bg_drawable_blue));


    }

}
