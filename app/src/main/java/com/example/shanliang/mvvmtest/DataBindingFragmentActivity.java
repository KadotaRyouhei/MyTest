package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import fragment.DataBindingFragment;

/**
 * Created by shanliang on 2018/3/9.
 */

public class DataBindingFragmentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_databinding_fragment);
        init();
    }

    private void init() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fl_container, new DataBindingFragment()).commit();
    }
}
