package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;

import customview.ProductListShiftLineView;

/**
 * Created by shanliang on 2018/3/16.
 */

public class AutoTextViewActivity extends Activity {

    private static final String TEXT_START = "圣诞前夜到";
    private static final String TEXT_MIDDLE= "去找一个叫";
    private static final String TEXT_END= "的暗夜行者";

    private static final String TEXT_PART_ONE = "必胜客pizza";
    private static final String TEXT_PART_TWO = "FFFFOOMENDLAWONGASJAS";
    //private static final String TEXT_PART_TWO = "OM";

    private ProductListShiftLineView atvLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_autotextview);
        init();
    }

    private void init() {
        atvLayout = (ProductListShiftLineView) findViewById(R.id.atv_layout);
        String text = TEXT_START + TEXT_PART_ONE + TEXT_MIDDLE + TEXT_PART_TWO + TEXT_END;
        SpannableString ss = new SpannableString(text);
        // 提示文案中 “用户query” 和 “暗改词” 需要加粗
        if (ss.length() >= 5 && 5 + TEXT_PART_ONE.length() <= ss.length()) {
            ss.setSpan(new StyleSpan(Typeface.BOLD),  5, 5 + TEXT_PART_ONE.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (ss.length() - 5 - TEXT_PART_TWO.length() >= 0) {
            ss.setSpan(new StyleSpan(Typeface.BOLD),  ss.length() - 5 - TEXT_PART_TWO.length(), ss.length() - 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        atvLayout.setExtraWidth(16);
        atvLayout.init(ss);
    }



}
