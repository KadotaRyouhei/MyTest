package model;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/14
 */
public class Person {
    private int _id;
    public String name;
    public int age;
    public String info;

    public Person() {

    }
    public Person(String name, int age, String info) {
        this.name = name;
        this.age = age;
        this.info = info;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int id) {
        _id = id;
    }

}
