package com.example.shanliang.mvvmtest;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * 类的功能与描述
 *
 * @author : shanliang
 * @date : 2019/1/2
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        mContext = getApplicationContext();
    }

    public static Context getInstance() {
        return mContext;
    }

}


