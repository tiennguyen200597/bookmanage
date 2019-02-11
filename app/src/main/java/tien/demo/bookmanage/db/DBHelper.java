package tien.demo.bookmanage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper implements Constants {
    public DBHelper(Context context) {
        super(context, "qls.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (Constants.isDEBUG) Log.e("CREATE_USER_TABLE", CREATE_USER_TABLE);
        if (Constants.isDEBUG) Log.e("CREATE_TYPE_TABLE", CREATE_TYPE_TABLE);
        if (Constants.isDEBUG) Log.e("CREATE_BILL_TABLE", CREATE_INVOICE_TABLE);
        if (Constants.isDEBUG) Log.e("CREATE_BILL_TABLE", CREATE_BOOK_TABLE);
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_TYPE_TABLE);
        db.execSQL(CREATE_INVOICE_TABLE);
        db.execSQL(CREATE_BILL_DETAIL_TABLE);
        db.execSQL(CREATE_BOOK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("");
    }


}
