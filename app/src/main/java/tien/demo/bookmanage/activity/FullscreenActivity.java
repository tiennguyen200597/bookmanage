package tien.demo.bookmanage.activity;

import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import tien.demo.bookmanage.db.DBHelper;
import tien.demo.bookmanage.base.BaseActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends BaseActivity {
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper=new DBHelper(FullscreenActivity.this);
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startNewActivity(LoginActivity.class);
                finish();
            }
        },1500);
        showMessage("Hello Guys,Open");
    }
}
