package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shanliang on 2018/6/26.
 */

public class RetrofitActivity extends Activity {

    private TextView tvResponse, tvGetHttp;
    private ImageView ivResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_activity);
        init();

    }

    private void init() {
        tvGetHttp = (TextView) findViewById(R.id.tv_get_http);
        tvResponse = (TextView) findViewById(R.id.tv_response);
        ivResponse = (ImageView) findViewById(R.id.iv_response);
    }


}
