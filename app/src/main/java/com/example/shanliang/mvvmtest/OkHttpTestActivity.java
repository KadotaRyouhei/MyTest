package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import okhttp3.OkHttpClient;

/**
 * Created by shanliang on 2018/11/28.
 */

public class OkHttpTestActivity extends Activity {

    private Button button;
    private TextView tvSendRequest;
    private List<Integer> list = new ArrayList<>();
    private PriorityQueue<Integer> pq = new PriorityQueue<>();

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
        OkHttpClient okHttpClient = new OkHttpClient();
    }
}
