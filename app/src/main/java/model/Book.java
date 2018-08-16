package model;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/16
 */
public class Book {

    private int _id;
    private String bookName;


    public Book() {

    }
    public Book(String bookName) {
        this.bookName = bookName;
    }

    public static final String[] PARTIAL_PROJECTION = new String[] {
            "_id",
            "bookName"
    };

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String name) {
        this.bookName = bookName;
    }

}
