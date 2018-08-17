package Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/16
 */
public class BookDBHelper extends SQLiteOpenHelper {

    //数据库名
    private static final String DATA_BASE_NAME = "book.db";

    //数据库版本号
    private static final int DATE_BASE_VERSION = 1;

    //表名-书
    public static final String BOOK_TABLE_NAME = "Book";

    //表名-用户
    public static final String USER_TABLE_NAME = "user";

    //创建表-书（两列：主键自增长、书名）
    private final String CREATE_BOOK_TABLE = "create table " + BOOK_TABLE_NAME
            + "(_id integer primary key autoincrement, bookName text)";

    //创建表-用户（三列：主键自增长、用户名、性别）
    private final String CREATE_USER_TABLE = "create table " + USER_TABLE_NAME
            + "(_id integer primary key autoincrement, userName text, sex text)";

    public BookDBHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATE_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(CREATE_BOOK_TABLE);
        //db.execSQL(CREATE_USER_TABLE);
        LocalCupboard.getAnnotatedInstance().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
