package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.shanliang.mvvmtest.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by shanliang on 2018/4/19.
 */

public class ReflectionTestActivity extends Activity{
    private static final String TAG = "reflection";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reflection_activity);
        init();
    }

    private void init() {

        try {
            Class reflectionTestCls = Class.forName("reflection.ReflectionTestClass");
            Field[] fields = reflectionTestCls.getDeclaredFields();
            for(Field field : fields) {
                StringBuilder sb = new StringBuilder();
                sb.append("\t");// 空格
                sb.append(Modifier.toString(field.getModifiers()) + " ");// 获得属性的修饰符，例如public，static等等
                sb.append(field.getType().getSimpleName() + " ");// 属性的类型的名字
                sb.append(field.getName() + ";\n");// 属性的名字+回车
                Log.d(TAG, "info is " + sb.toString());

            }

            Method[] methods = reflectionTestCls.getDeclaredMethods();
            for(Method method : methods) {
                StringBuilder sb = new StringBuilder();
                sb.append("\t");// 空格
                sb.append(Modifier.toString(method.getModifiers()) + " ");// 获得属性的修饰符，例如public，static等等
                sb.append(method.getName() + ";\n");// 属性的名字+回车
                Log.d(TAG, "info is " + sb.toString());
            }
        } catch (Exception e) {

        }

    }
}
