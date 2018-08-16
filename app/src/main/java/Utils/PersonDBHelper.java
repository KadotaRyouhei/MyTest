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
public class PersonDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "persons.db";

    private static final int DATABASE_VERSION = 1;

    public PersonDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        LocalCupboard.getInstance().withDatabase(db).createTables();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        LocalCupboard.getInstance().withDatabase(db).upgradeTables();
    }
}
