package tien.demo.bookmanage.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import tien.demo.bookmanage.R;

public class InvoiceActivity extends AppCompatActivity {
    long datePicker = -1;
    private TextView tvAdd;
    private TextView tvChooseDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvAdd = (TextView) findViewById(R.id.tvAdd);
        //show dialog thêm hóa đơn
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
        View dialogView = inflater.inflate(R.layout.dialog_invoice, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        Button add = dialogView.findViewById(R.id.btn_add_invoice);
        Button huy = dialogView.findViewById(R.id.btn_cancel_invoice);
        Button btnChooseDate = dialogView.findViewById(R.id.btn_choose_date);
        tvChooseDate = dialogView.findViewById(R.id.tv_choose_date);
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
        //chow ngày tháng
        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

    }

    // hàm show ngày tháng
    public void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        // thiet lap thong tin cho date picker
        final DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Integer yy = year;
                Integer mm = month;
                Integer dd = dayOfMonth;
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                //
                long startTime = calendar.getTimeInMillis();
                InvoiceActivity.this.datePicker = calendar.getTimeInMillis();
                tvChooseDate.setText(new Date(startTime).toString());
            }
        }, year, month, day);

        datePicker.show();
    }

}
