package model;

import java.util.Observable;

/**
 * Created by shanliang on 2018/5/9.
 */

public class JianShuAndroid extends Observable {
    public void postNewContentToCoder(String content) {
        setChanged();
        notifyObservers(content);
    }
}
