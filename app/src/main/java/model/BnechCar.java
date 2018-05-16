package model;

import annotation.CarNameTarget;
import annotation.CarSalerTarget;

/**
 * Created by shanliang on 2018/4/19.
 */

public class BnechCar {
    @CarNameTarget(name = "奔驰")
    private String name;

    @CarSalerTarget(salerName = "Sunny", age = 25)
    private String salerInfo;


}
