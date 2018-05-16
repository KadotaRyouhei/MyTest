package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import fragment.FirstFragment;

/**
 * Created by shanliang on 2018/1/26.
 */

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        init();
    }

    private void init() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_container,new FirstFragment());
        fragmentTransaction.commit();
    }
}
