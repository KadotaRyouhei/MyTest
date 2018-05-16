package reflection;

import android.util.Log;

/**
 * Created by shanliang on 2018/4/19.
 */

public class ReflectionTestClass {
    private static final String TAG = "reflection";



    private String address;
    private String port;
    private int number;

    public void printInfo() {
        Log.d(TAG,"info is " + address + ":" + port);
    }

    private void myMethod(int number, String sex) {

    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
