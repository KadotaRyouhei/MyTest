package com.example.shanliang.mvvmtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.AutoTextViewActivity;
import com.example.shanliang.mvvmtest.CardViewPagerActivity;
import com.example.shanliang.mvvmtest.DataBindingActivity;
import com.example.shanliang.mvvmtest.DataBindingFragmentActivity;
import com.example.shanliang.mvvmtest.FirstActivity;
import com.example.shanliang.mvvmtest.KillAssSecondActivity;
import com.example.shanliang.mvvmtest.R;
import com.example.shanliang.mvvmtest.RXJavaActivity;
import com.example.shanliang.mvvmtest.RecyclerViewActivity;
import com.example.shanliang.mvvmtest.SwipeCardActivity;

import com.example.shanliang.mvvmtest.ReflectionTestActivity;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    TextView tvGoIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        init();
    }

    private void init() {
        tvGoIndex = (TextView) findViewById(R.id.tv_go_index);
        tvGoIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, IndexActivity.class);
                startActivity(intent);
            }
        });

    }
}
