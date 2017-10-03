package programmer.box.helperutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import programmer.box.utilityhelper.UtilImage;
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

    }
}
