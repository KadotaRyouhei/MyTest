package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by shanliang on 2018/5/9.
 * 观察者模式
 */

public class ObservableActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.most_hot_activity);
    }

}
