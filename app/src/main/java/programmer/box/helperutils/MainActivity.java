package programmer.box.helperutils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.TooltipCompat;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

import programmer.box.utilityhelper.UtilAsyncTask;
import programmer.box.utilityhelper.UtilDevice;
import programmer.box.utilityhelper.UtilImage;
import programmer.box.utilityhelper.UtilLog;
import programmer.box.utilityhelper.UtilMedia;
import programmer.box.utilityhelper.UtilNotification;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UtilLog.FILTER_BY_CLASS_NAME = "box";

        UtilLog.d("Hello");
        UtilLog.e("Hello");
        UtilLog.w("Hello");
        UtilLog.a("Hello");
        UtilLog.v("Hello");

        UtilLog.SHOW_PRETTY = false;

        UtilLog.d("Hello");
        UtilLog.e("Hello");
        UtilLog.w("Hello");
        UtilLog.a("Hello");
        UtilLog.v("Hello");

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

                /*UtilNotification.showSnackbar(v, "Hello", UtilNotification.Lengths.LONG, "World", new UtilNotification.SnackBarAction() {
                    @Override
                    public void snackClick(Snackbar snackbar) {
                        snackbar.dismiss();
                    }
                });*/

                UtilNotification.showColoredToast(v.getContext(), "Hello There", Toast.LENGTH_LONG, Color.BLUE);
            }
        });

        Button toast = findViewById(R.id.toasty);

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UtilNotification.showToast(MainActivity.this, "Hello", UtilNotification.Lengths.LONG);

                Dialog dialogs = new AlertDialog.Builder(v.getContext())
                        .setMessage("Please Wait").setTitle("Wait please").create();

                @SuppressLint("StaticFieldLeak") UtilAsyncTask task = new UtilAsyncTask(dialogs) {
                    @Override
                    public void onPreExecutes() {
                        UtilLog.e("Hello");
                    }

                    @Override
                    public boolean onBackgrounds(Void... voids) {

                        for(int i=0;i<1000;i++) {
                            publishProgress(i);
                        }

                        return true;
                    }

                    @Override
                    public void onPostExecutes(Boolean o) {
                        UtilLog.e("World");
                    }

                    @Override
                    public void onProgressUpdates(Integer[] values) {
                        UtilLog.i("i: " + values[0]);
                        dialog.setTitle("i: " + values[0]);
                    }
                }.startTask();
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
                                public void snackClick(Snackbar snackbar, View v) {
                                    //UtilMedia.mediaRouter();
                                    UtilNotification.showToast(v.getContext(), "Hi", Toast.LENGTH_LONG);
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

        toast.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                //UtilMedia.textToSpeech(MainActivity.this, "Hello world");

                UtilNotification.createColoredSnackbar(v, "Hello", Snackbar.LENGTH_LONG, "Hello", new UtilNotification.SnackBarAction() {
                    @Override
                    public void snackClick(Snackbar snackbar, View v) {
                        snackbar.dismiss();
                    }
                }, Color.RED, Color.DKGRAY).show();

                return true;
            }
        });

        noti.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                UtilMedia.textToSpeech(MainActivity.this, "Kawaii");

                return true;
            }
        });

        notiReply.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                UtilMedia.speechToText(v.getContext(), new UtilMedia.SpeechListener() {
                    @Override
                    public void getResult(String text) {
                        UtilLog.v(text);
                    }
                });
                return true;
            }
        });

        UtilDevice.getBatteryState(this, new UtilDevice.BatteryInfo() {
            @Override
            public void currentLevel(int level) {
                UtilLog.e("The current level is " + level + "%");
                UtilNotification.showColoredToast(MainActivity.this, "The current level is " + level + "%", Toast.LENGTH_LONG, Color.GRAY);
            }
        });


    }
}
