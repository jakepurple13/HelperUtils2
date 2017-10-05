package programmer.box.helperutils;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import programmer.box.utilityhelper.UtilImage;
import programmer.box.utilityhelper.UtilLog;
import programmer.box.utilityhelper.UtilMedia;
import programmer.box.utilityhelper.UtilNotification;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UtilLog.d("Hello");
        UtilLog.e("Hello");
        UtilLog.w("Hello");
        UtilLog.e("Hello");
        UtilLog.v("Hello");

        UtilLog.d("Hello", "World");
        UtilLog.e("Hello", "World");
        UtilLog.w("Hello", "World");
        UtilLog.e("Hello", "World");
        UtilLog.v("Hello", "World");

        ImageView iv = findViewById(R.id.imageView);

        UtilImage.changeImageViewTintColor(iv, R.color.colorAccent);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilImage.changeImageViewTintColor((ImageView) v, R.color.colorPrimaryDark);
            }
        });

        Button noti = findViewById(R.id.noti);

        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilNotification.sendNotification(MainActivity.this, android.R.mipmap.sym_def_app_icon, "Title", "Message", "Channel", MainActivity.class, 1);
            }
        });

        Button notiReply = findViewById(R.id.noti_reply);

        notiReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilNotification.sendReplyNotification(MainActivity.this, android.R.mipmap.sym_def_app_icon, android.R.mipmap.sym_def_app_icon, "Reply", "Reply", "REPLYID", "Title", "Message","Channel", MainActivity.class, 1);
            }
        });

        Button channel = findViewById(R.id.channel);

        channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilNotification.createNotificationChannel(MainActivity.this, "Channel", "Description", "Channel");
            }
        });

        Button group = findViewById(R.id.group);

        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilNotification.createNotificationGroup(MainActivity.this, "group", "group_name");
            }
        });

        Button snack = findViewById(R.id.snacky);

        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UtilNotification.showSnackbar(v, "Hello", UtilNotification.Lengths.LONG, "World", new UtilNotification.SnackBarAction() {
                    @Override
                    public void snackClick(Snackbar snackbar) {
                        snackbar.dismiss();
                    }
                });
            }
        });

        Button toast = findViewById(R.id.toasty);

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilNotification.showToast(MainActivity.this, "Hello", UtilNotification.Lengths.LONG);
            }
        });

        snack.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                UtilNotification.showMenu(MainActivity.this, v, R.menu.sample_menu, new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if(item.getItemId()==R.id.hello) {
                            UtilNotification.showSnackbar(v, "Hello was pressed", UtilNotification.Lengths.LONG, "Cool!", new UtilNotification.SnackBarAction() {
                                @Override
                                public void snackClick(Snackbar snackbar) {
                                    UtilMedia.mediaRouter();
                                    snackbar.dismiss();
                                }
                            });
                            return true;
                        }

                        return false;
                    }
                });
                return true;
            }
        });





    }
}
