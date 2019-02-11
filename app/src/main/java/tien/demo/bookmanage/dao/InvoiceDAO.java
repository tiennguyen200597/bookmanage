package tien.demo.bookmanage.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import tien.demo.bookmanage.db.Constants;
import tien.demo.bookmanage.db.DBHelper;
import tien.demo.bookmanage.model.Invoice;

public class InvoiceDAO implements Constants {

    private DBHelper databaseHelper;

    public InvoiceDAO(DBHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


    public long insertInvoice(Invoice Invoice) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(I_ID, Invoice.id);
        contentValues.put(I_DATE, Invoice.date);

        long result = sqLiteDatabase.insert(TABLE_INVOICE, null, contentValues);

        sqLiteDatabase.close();
        return result;


    }

    public long updateInvoice(Invoice Invoice) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(I_DATE, Invoice.date);

        long result = sqLiteDatabase.update(TABLE_INVOICE, contentValues,
                I_ID + "=?", new String[]{Invoice.id});


        sqLiteDatabase.close();
        return result;
    }


    public long deleteInvoice(String id) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        long result = sqLiteDatabase.delete(TABLE_INVOICE, I_ID + "=?", new String[]{id});


        sqLiteDatabase.close();
        return result;

    }


    public List<Invoice> getAllInvoices() {

        List<Invoice> Invoices = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_INVOICE,
                null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                String id = cursor.getString(cursor.getColumnIndex(I_ID));
                long date = cursor.getLong(cursor.getColumnIndex(I_DATE));

                Invoice Invoice = new Invoice(id, date);

                Invoices.add(Invoice);


            } while (cursor.moveToNext());
        }

        return Invoices;

    }


    public Invoice getInvoiceByID(String InvoiceId) {

        Invoice Invoice = null;

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_INVOICE, new String[]{I_ID, I_DATE},
                I_ID + "=?",
                new String[]{InvoiceId}, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            String id = cursor.getString(cursor.getColumnIndex(I_ID));
            long date = cursor.getLong(cursor.getColumnIndex(I_DATE));

            Invoice = new Invoice(id, date);
        }

        return Invoice;


    }
}
