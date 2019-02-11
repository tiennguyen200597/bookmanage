package tien.demo.bookmanage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tien.demo.bookmanage.R;
import tien.demo.bookmanage.model.Book;
import tien.demo.bookmanage.model.User;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.BookHolder> {
    private Context context;
    public List<Book> books;

    public AdapterBook(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_item, viewGroup, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder bookHolder, int i) {
        bookHolder.book = books.get(i);
        bookHolder.tvIdBook.setText(bookHolder.book.id);
        /*userHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        bookHolder.tvAmount.setText(bookHolder.book.typeID);


    }

    @Override
    public int getItemCount() {
        if (books == null) return 0;
        else return books.size();
    }

    class BookHolder extends RecyclerView.ViewHolder {
        private TextView tvIdBook;
        private TextView tvAmount;
        Book book;


        public BookHolder(@NonNull View itemView) {
            super(itemView);


            tvIdBook = (TextView) itemView.findViewById(R.id.tv_id_book);
            tvAmount = (TextView) itemView.findViewById(R.id.tv_amount);

        }
    }
}
