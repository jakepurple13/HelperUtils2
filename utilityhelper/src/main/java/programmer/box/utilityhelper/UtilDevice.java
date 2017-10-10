package programmer.box.utilityhelper;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.BatteryManager;
import android.os.Build;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 10/5/17.
 */

public class UtilDevice {

    public static void changeStatusBarColor(Activity activity, int color) {
        Window window = activity.getWindow();
        window.setStatusBarColor(color);
    }

    public static float getBatteryInfo(Context context) {

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = level / (float)scale;

        return batteryPct;
    }

    public static void getBatteryState(Context context, final BatteryInfo info) {

        BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context ctxt, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                info.currentLevel(level);
            }
        };

        context.registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    public interface BatteryInfo {

        public void currentLevel(int level);

    }

    /**
     * requestPermissions - request permissions
     * @param activity  Activity
     * @param permissionsList  list of permissions
     *                         should look something like: +
     *                         new String[]{@link Manifest.permission}.CAMERA, {@link Manifest.permission}.VIBRATE};
     *                         + Don't forget to add permissions to the manifest.xml "permission android:name="android.permission.CAMERA"
     * @param requestCode  request code for activity result
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static void requestPermissions(Activity activity, String[] permissionsList, int requestCode) {

        List<String> permissions = new ArrayList<>();

        // loop through permissions
        for (String permission : permissionsList) {
            if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(permission);
            }
        }

        // if permissions list is not empty, request permission
        if (!permissions.isEmpty()) {
            activity.requestPermissions(permissions.toArray(new String[permissions.size()]), requestCode);
        }
    }

}
