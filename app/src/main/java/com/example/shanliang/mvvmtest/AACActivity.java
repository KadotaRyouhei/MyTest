package com.example.shanliang.mvvmtest;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import viewmodel.NameViewModel;

/**
 * Created by shanliang on 2018/5/29.
 */

public class AACActivity extends AppCompatActivity {
    private NameViewModel viewModel;
    private TextView tvName, tvChange;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aac_activity);
        init();
        initListener();
        initData();
    }

    private void init() {
        tvName = (TextView) findViewById(R.id.tv_name);
        tvChange = (TextView) findViewById(R.id.tv_change);
        viewModel = ViewModelProviders.of(this).get(NameViewModel.class);
    }

    private void initListener() {
        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                String content = "AAC第" + count + "次改造";
                viewModel.getCurrentName().setValue(content);
            }
        });
    }

    private void initData() {
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvName.setText(s);
            }
        };

        viewModel.getCurrentName().observe(this, nameObserver);
    }
}
