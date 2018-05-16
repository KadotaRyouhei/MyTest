package model;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by shanliang on 2018/5/9.
 */

public class Coder implements Observer {
    private String yourName;
    public Coder(String yourName) {
        this.yourName = yourName;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public String toString() {
        return "Your name is" + yourName;
    }
}
