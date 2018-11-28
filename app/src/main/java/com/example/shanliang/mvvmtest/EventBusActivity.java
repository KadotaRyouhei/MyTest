package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import model.MessageEvent;

/**
 * Created by shanliang on 2018/11/22.
 */

public class EventBusActivity extends Activity {

    private TextView tvTitle, tvJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_bus_activity);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvJump = (TextView) findViewById(R.id.tv_jump);
        EventBus.getDefault().register(this);
        initListener();

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        tvTitle.setText(messageEvent.getMessage());
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    private void initListener() {
        tvJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(EventBusActivity.this,RXJava2Activity.class);
                startActivity(intent);
            }
        });
    }


}
