package orbital.milestone2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {

        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(user text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    //insert into database
    public boolean insert(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", user);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }

    //check if user legit
    public boolean checkUser(String user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where user=?", new String[]{user});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public boolean checkReal(String user, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where user=? and password=?", new String[]{user, pass});
        if(cursor.getCount()>0) return true;
        else return false;
    }
}
