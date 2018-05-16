package com.example.shanliang.mvvmtest;

import android.view.View;
import android.widget.Toast;

import entity.User;

/**
 * Created by shanliang on 2018/3/7.
 */

public class ViewModel {
    private User user;
    private boolean adverse = true;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void updateFirstName(View view) {
        if(user != null) {

            if(adverse) {
                user.setFirstName("LinLinA");
                adverse = false;
            } else {
                user.setFirstName("ShiLinB");
                adverse = true;
            }
        }
    }

    public void showToast(View view) {
        Toast.makeText(view.getContext(), "展示吐司", Toast.LENGTH_SHORT).show();
    }
}
