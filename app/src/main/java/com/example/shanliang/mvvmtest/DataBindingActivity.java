package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.shanliang.mvvmtest.databinding.DatabindingActivityBinding;

import entity.User;

/**
 * Created by shanliang on 2018/2/6.
 */

public class DataBindingActivity extends Activity {
    ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.databinding_activity);
       // init();
        DatabindingActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.databinding_activity);
        viewModel = new ViewModel();
        viewModel.setUser(new User("Shi", "Lin"));
        binding.setUser(viewModel.getUser());
        binding.setViewmodel(viewModel);

    }

   /* private void init() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_container,new DataBindingFragment());
        fragmentTransaction.commit();
    }*/
}
