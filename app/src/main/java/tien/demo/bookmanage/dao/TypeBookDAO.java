package tien.demo.bookmanage.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import tien.demo.bookmanage.db.Constants;
import tien.demo.bookmanage.db.DBHelper;
import tien.demo.bookmanage.model.TypeBook;

public class TypeBookDAO implements Constants {

    private DBHelper databaseHelper;

    public TypeBookDAO(DBHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


    public long insertTypeBook(TypeBook typeBook) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TB_COLUMN_TYPE_BOOK_ID, typeBook.id);
        contentValues.put(TB_COLUMN_DESCRIPTION, typeBook.description);
        contentValues.put(TB_COLUMN_TYPE_NAME, typeBook.name);
        contentValues.put(TB_COLUMN_POSITION, typeBook.position);

        long result = db.insert(TYPE_BOOK_TABLE, null, contentValues);

        if (Constants.isDEBUG) Log.e("insertTypeBook", "insertTypeBook ID : " + typeBook.id);

        db.close();

        return result;

    }

    public long deleteTypeBook(String typeId) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long result = db.delete(TYPE_BOOK_TABLE, TB_COLUMN_TYPE_BOOK_ID + " = ?",
                new String[]{String.valueOf(typeId)});
        db.close();
        return result;

    }

    public long updateTypeBook(TypeBook typeBook) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TB_COLUMN_DESCRIPTION, typeBook.description);
        contentValues.put(TB_COLUMN_TYPE_NAME, typeBook.name);
        contentValues.put(TB_COLUMN_POSITION, typeBook.position);

        // updating row
        return db.update(USER_TABLE, contentValues, TB_COLUMN_TYPE_BOOK_ID + " = ?",
                new String[]{String.valueOf(typeBook.id)});
    }

    public List<TypeBook> getAllTypeBooks() {

        List<TypeBook> typeBooks = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TYPE_BOOK_TABLE;

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(TB_COLUMN_TYPE_BOOK_ID));

                String name = cursor.getString(cursor.getColumnIndex(TB_COLUMN_TYPE_NAME));

                String description = cursor.getString(cursor.getColumnIndex(TB_COLUMN_DESCRIPTION));

                String position = cursor.getString(cursor.getColumnIndex(TB_COLUMN_POSITION));

                // khoi tao type Book voi cac gia tri lay duoc

                TypeBook typeBook = new TypeBook();
                typeBook.id = id;
                typeBook.name = name;
                typeBook.description = description;
                typeBook.position = position;
                typeBooks.add(typeBook);

            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        return typeBooks;

    }

    public TypeBook getTypeBookByID(String typeID) {

        TypeBook typeBook = null;

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // Truyen vao Ten bang, array bao gom ten cot, ten cot khoa chinh, gia tri khoa chinh, cac tham so con lai la null

        Cursor cursor = db.query(TYPE_BOOK_TABLE, new String[]{TB_COLUMN_TYPE_BOOK_ID, TB_COLUMN_TYPE_NAME, TB_COLUMN_DESCRIPTION, TB_COLUMN_POSITION},
                TB_COLUMN_TYPE_BOOK_ID + "=?", new String[]{typeID},
                null, null, null, null);

        // moveToFirst : kiem tra xem cursor co chua du lieu khong, ham nay tra ve gia tri la true or false
        if (cursor != null && cursor.moveToFirst()) {

            String id = cursor.getString(cursor.getColumnIndex(TB_COLUMN_TYPE_BOOK_ID));

            String name = cursor.getString(cursor.getColumnIndex(TB_COLUMN_TYPE_NAME));

            String description = cursor.getString(cursor.getColumnIndex(TB_COLUMN_DESCRIPTION));

            String position = cursor.getString(cursor.getColumnIndex(TB_COLUMN_POSITION));

            // khoi tao type Book voi cac gia tri lay duoc

            typeBook = new TypeBook();
            typeBook.id = id;
            typeBook.name = name;
            typeBook.description = description;
            typeBook.position = position;
        }
        cursor.close();
        return typeBook;

    }
}
