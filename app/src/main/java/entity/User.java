package entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.view.View;

import com.example.shanliang.mvvmtest.BR;

import java.net.PortUnreachableException;

/**
 * Created by shanliang on 2018/2/6.
 */

public class User extends BaseObservable{
    private String firstName;
    private String lastName;
    public static final String FIRST_NAME = "ShiLinLin";
    public final ObservableInt age = new ObservableInt();


    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

}
