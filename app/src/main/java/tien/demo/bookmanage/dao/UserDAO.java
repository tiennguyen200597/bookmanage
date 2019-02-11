package tien.demo.bookmanage.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tien.demo.bookmanage.db.Constants;
import tien.demo.bookmanage.db.DBHelper;
import tien.demo.bookmanage.model.User;

public class UserDAO implements Constants {
    DBHelper dbHelper;
    public UserDAO(Context context){
        this.dbHelper=new DBHelper(context);
    }
    public long insertUser(User user) {

        long result = -1;

        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_USER_NAME, user.USER_USER_NAME);
        contentValues.put(USER_PASSWORD, user.USER_PASSWORD);
        contentValues.put(USER_PHONE, user.USER_PHONE);
        contentValues.put(USER_FULL_NAME, user.USER_FULL_NAME);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public long updateUser(User user) {
        long result = -1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_USER_NAME, user.USER_USER_NAME);
        contentValues.put(USER_PASSWORD, user.USER_PASSWORD);
        contentValues.put(USER_PHONE, user.USER_PHONE);
        contentValues.put(USER_FULL_NAME, user.USER_FULL_NAME);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        result = sqLiteDatabase.update(USER_TABLE, contentValues, USER_USER_NAME + "=?",
                new String[]{user.USER_USER_NAME});
        return result;
    }

    public long deleteUser(String user_name) {
        long result = -1;
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        result = sqLiteDatabase.delete(USER_TABLE, USER_USER_NAME + "=?",
                new String[]{user_name});
        return result;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String QUERY = "SELECT * FROM " + USER_TABLE;
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(QUERY, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                //di chuyen coi vi tri dau tien
                cursor.moveToFirst();
                // check xem sau do con ko
                while (!cursor.isAfterLast()) {
                    String USER_USER_NAME_ = cursor.getString(cursor.getColumnIndex(USER_USER_NAME));
                    String USER_PASSWORD_ = cursor.getString(cursor.getColumnIndex(USER_PASSWORD));
                    String USER_PHONE_ = cursor.getString(cursor.getColumnIndex(USER_PHONE));
                    String USER_FULL_NAME_ = cursor.getString(cursor.getColumnIndex(USER_FULL_NAME));
                    User user = new User();
                    user.USER_USER_NAME = USER_USER_NAME_;
                    user.USER_PASSWORD = USER_PASSWORD_;
                    user.USER_PHONE = USER_PHONE_;
                    user.USER_FULL_NAME = USER_FULL_NAME_;
                    // add vao array
                    users.add(user);
                    //di chuyen toi vi tri tiep theo
                    cursor.moveToNext();
                }
                // dong ket noi
                cursor.close();
                sqLiteDatabase.close();
            }
        }
        return users;
    }
}
