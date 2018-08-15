package Utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import model.Person;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/14
 */
public class DBManager {
    private DBHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public void add(List<Person> list) {
        db.beginTransaction();
        try{
            for(Person p : list) {
                //db.execSQL("INSERT INTO person VALUES(null,p.name,p.age,p.info)");
                db.execSQL("INSERT INTO person VALUES(null,?,?,?)",
                                                 new Object[]{p.name,p.age,p.info});
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public List<Person> findAllPerson() {
        ArrayList<Person> persons = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM person", null);
        while(c.moveToNext()) {
            Person p = new Person();
            p.set_id(c.getInt(c.getColumnIndex("_id")));
            p.name = c.getString(c.getColumnIndex("name"));
            p.age = c.getInt(c.getColumnIndex("age"));
            p.info = c.getString(c.getColumnIndex("info"));
            persons.add(p);
        }
        c.close();
        return persons;
    }

    public void closeDB() {
        db.close();
    }
}
