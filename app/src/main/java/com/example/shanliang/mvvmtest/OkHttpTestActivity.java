package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by shanliang on 2018/11/28.
 */

public class OkHttpTestActivity extends Activity {

    private TextView tvSendRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp_test_activity);
        init();
        initListener();
    }


    private void init() {
        tvSendRequest = (TextView) findViewById(R.id.tv_send);
    }

    private void initListener() {
        tvSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void sendRequest() {

    }
}
