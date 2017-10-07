package programmer.box.utilityhelper;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.view.Window;

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

}
