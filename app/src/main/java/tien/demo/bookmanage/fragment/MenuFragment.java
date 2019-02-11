package tien.demo.bookmanage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import tien.demo.bookmanage.R;
import tien.demo.bookmanage.activity.BookActivity;
import tien.demo.bookmanage.activity.BookCategoryActivity;
import tien.demo.bookmanage.activity.InvoiceActivity;
import tien.demo.bookmanage.activity.StatisticActivity;
import tien.demo.bookmanage.activity.TopPopularActivity;
import tien.demo.bookmanage.activity.UserActivity;

public class MenuFragment extends Fragment {
    private ImageView imgUser;
    private ImageView imgBookCategory;
    private ImageView imgBook;
    private ImageView imgInvoice;
    private ImageView imgTopPopular;
    private ImageView imgStatistic;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        //init
        imgUser = (ImageView) view.findViewById(R.id.imgUser);
        imgBookCategory = (ImageView) view.findViewById(R.id.imgBookCategory);
        imgBook = (ImageView) view.findViewById(R.id.imgBook);
        imgInvoice = (ImageView) view.findViewById(R.id.imgInvoice);
        imgTopPopular = (ImageView) view.findViewById(R.id.imgTopPopular);
        imgStatistic = (ImageView) view.findViewById(R.id.imgStatistic);
        //set Onclick User

        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inflater.getContext(), UserActivity.class);
                startActivity(intent);

            }
        });
        //set Onclick BookCategory
        imgBookCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(inflater.getContext(), BookCategoryActivity.class));
            }
        });
        //set Onclick Book
        imgBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(inflater.getContext(), BookActivity.class));
            }
        });
        //set Onclick Invoice
        imgInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(inflater.getContext(), InvoiceActivity.class));
            }
        });
        //set Onclick TopPopular
        imgTopPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(inflater.getContext(), TopPopularActivity.class));
            }
        });
        //set Onclick Statistic
        imgStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(inflater.getContext(), StatisticActivity.class));
            }
        });

        return view;
    }


}
