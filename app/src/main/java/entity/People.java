package entity;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by shanliang on 2018/3/9.
 */

public class People {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean isMan = new ObservableBoolean();
    public People(String name, int age, boolean isMan) {
        this.name.set(name);
        this.age.set(age);
        this.isMan.set(isMan);
    }
}
