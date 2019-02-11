package tien.demo.bookmanage.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import tien.demo.bookmanage.db.Constants;
import tien.demo.bookmanage.db.DBHelper;
import tien.demo.bookmanage.model.InvoiceDetail;

public class InvoiceDetailDAO implements Constants {

    DBHelper databaseHelper;

    public InvoiceDetailDAO(DBHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


    public List<InvoiceDetail> getAllInvoiceDetailByBillID(String billID) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        List<InvoiceDetail> InvoiceDetails = new ArrayList<>();

        String SELECT_ALL_BILL_DETAIL_BY_BILL_ID = "SELECT * FROM " + TABLE_INVOICE_DETAIL +
                " WHERE " + DETAIL_INVOICE_ID + " = " + "'" + billID + "'";

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_BILL_DETAIL_BY_BILL_ID, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                String id = cursor.getString(cursor.getColumnIndex(DETAIL_ID));
                String book_id = cursor.getString(cursor.getColumnIndex(DETAIL_BOOK_ID));
                String bill_id = cursor.getString(cursor.getColumnIndex(DETAIL_INVOICE_ID));
                int quality = cursor.getInt(cursor.getColumnIndex(DETAIL_QUALITY));

                InvoiceDetail InvoiceDetail = new InvoiceDetail();
                InvoiceDetail.id = id;
                InvoiceDetail.billID = bill_id;
                InvoiceDetail.bookID = book_id;
                InvoiceDetail.quality = quality;
                InvoiceDetails.add(InvoiceDetail);

            } while (cursor.moveToNext());

        }
        sqLiteDatabase.close();
        return InvoiceDetails;
    }


    public long insertInvoiceDetail(InvoiceDetail InvoiceDetail) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DETAIL_ID, InvoiceDetail.id);
        contentValues.put(DETAIL_INVOICE_ID, InvoiceDetail.billID);
        contentValues.put(DETAIL_BOOK_ID, InvoiceDetail.bookID);
        contentValues.put(DETAIL_QUALITY, InvoiceDetail.quality);

        long result = sqLiteDatabase.insert(TABLE_INVOICE_DETAIL, null, contentValues);
        return result;
    }
}
