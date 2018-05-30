package viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import entity.User;

/**
 * Created by shanliang on 2018/5/29.
 */

public class UserProfileViewModel extends ViewModel {

    private String userId;
    private LiveData<User> user;

    public void init(String userId) {
        this.userId = userId;
    }

    public LiveData<User> getUser() {
        return user;
    }
}
