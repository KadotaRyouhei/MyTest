package Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/14
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test.db";

    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //LocalCupboard.getAnnotatedInstance().withDatabase(db).createTables();
        db.execSQL("CREATE TABLE IF NOT EXISTS person(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name VARCHAR,age INTEGER, info TEXT)");//建表，对数据库进行操作等

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        //LocalCupboard.getAnnotatedInstance().withDatabase(db).upgradeTables();
        db.execSQL("ALTER TABLE person COLUMN other STRING");
    }
}
