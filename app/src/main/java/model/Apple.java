package model;

import annotation.FruitName;
import annotation.FruitProvider;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/7/23
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitProvider(id = 1, name = "红富士集团", address = "陕西")
    private String appleProvider;

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;

    }

    public String getAppleProvider() {
        return this.appleProvider;
    }


}
