package programmer.box.helperutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import programmer.box.utilityhelper.UtilLog;

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

    }
}
