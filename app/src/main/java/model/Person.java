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

    public static final String[] PARTIAL_PROJECTION = new String[] {
            "_id",
            "name",
            "age",
            "info"
    };

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
