package programmer.box.utilityhelper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jacob on 12/12/17.
 */

public class UtilPreferences {

    private static SharedPreferences sharedPref;

    public static void init(Activity activity) {
        sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
    }

    public static void put(String key, int value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void put(String key, String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void put(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void put(String key, float value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static void put(String key, long value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static int get(String key, int defaultValue) {
        return sharedPref.getInt(key, defaultValue);
    }

    public static float get(String key, float defaultValue) {
        return sharedPref.getFloat(key, defaultValue);
    }

    public static long get(String key, long defaultValue) {
        return sharedPref.getLong(key, defaultValue);
    }

    public static boolean get(String key, boolean defaultValue) {
        return sharedPref.getBoolean(key, defaultValue);
    }

    public static String get(String key, String defaultValue) {
        return sharedPref.getString(key, defaultValue);
    }

}
