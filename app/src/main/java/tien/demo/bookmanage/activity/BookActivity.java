package tien.demo.bookmanage.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import tien.demo.bookmanage.dao.BookDAO;
import tien.demo.bookmanage.db.DBHelper;
import tien.demo.bookmanage.R;
import tien.demo.bookmanage.adapter.AdapterBook;
import tien.demo.bookmanage.model.Book;

public class BookActivity extends AppCompatActivity {
    private TextView tvAdd;
    private RecyclerView recyclerView;
    private AdapterBook adapterBook;
    private List<Book> books;
    private DBHelper dbHelper;
    private LinearLayoutManager layoutManager;
    private BookDAO bookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    //
        dbHelper = new DBHelper(BookActivity.this);
        bookDAO=new BookDAO(dbHelper);
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.id ="s "+i;
            book.price = new Random().nextInt(100);
            book.typeID = "tyle"+i;
            book.author = "123456";
            book.producer = "12d3456";
            book.quality = new Random().nextInt(100);;
            bookDAO.insertBook(book);
        }
        //
        tvAdd = (TextView) findViewById(R.id.tvAdd);
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAllUser();
            }
        });
        recyclerView = findViewById(R.id.lv_list_book);
        books = bookDAO.getAllBooks();
        adapterBook = new AdapterBook(this, books);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterBook);

        //
        tvAdd = (TextView) findViewById(R.id.tvAdd);
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAllUser();
            }
        });
    }
    public void showDialogAllUser() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_add_book, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        Button add = dialogView.findViewById(R.id.btn_add_book);
        Button huy = dialogView.findViewById(R.id.btn_cancel_book);
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });

    }

}
