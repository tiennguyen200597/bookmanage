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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import tien.demo.bookmanage.dao.UserDAO;
import tien.demo.bookmanage.db.DBHelper;
import tien.demo.bookmanage.R;
import tien.demo.bookmanage.adapter.AdapterUser;
import tien.demo.bookmanage.base.RecyclerViewClickListener;
import tien.demo.bookmanage.base.RecyclerViewTouchListener;
import tien.demo.bookmanage.model.User;

public class UserActivity extends AppCompatActivity {
    private TextView tvAdd;
    private RecyclerView recyclerView;
    private AdapterUser adapterUser;
    private List<User> users;
    private DBHelper dbHelper;
    private LinearLayoutManager layoutManager;
    private UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //
        dbHelper = new DBHelper(UserActivity.this);
        userDAO=new UserDAO(this);
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.USER_USER_NAME = "Nguyễn Văn Tiến " + i;
            user.USER_FULL_NAME = "Tiến Nguyễn " + new Random().nextInt(100);
            user.USER_PHONE = new Random().nextInt(100000) + "";
            user.USER_PASSWORD = "123456";
            userDAO.insertUser(user);
        }
        //
        tvAdd = (TextView) findViewById(R.id.tvAdd);
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAllUser();
            }
        });
        recyclerView = findViewById(R.id.lv_list);
        users = userDAO.getAllUser();
        adapterUser = new AdapterUser(this, users);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterUser);
        // add sự kiện lich cho item
        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), recyclerView, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), users.get(position).USER_USER_NAME + " is clicked!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), view);
                popup.getMenuInflater().inflate(R.menu.poupup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(UserActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();//showing popup menu

            }
        }));
    }

    //hàm show dialog thêm người dùng
    public void showDialogAllUser() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_add_user, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        Button add = dialogView.findViewById(R.id.btn_add_user);
        Button huy = dialogView.findViewById(R.id.btn_cancel);
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
    }


}
