package programmer.box.utilityhelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jacob on 10/3/17.
 */

public class UtilImage {

    /*public static Drawable colorImage(Context context, int resid, int color) {
        Drawable mDrawable = context.getResources().getDrawable(resid, null);
        mDrawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        return mDrawable;
    }

    public static Drawable colorImage(Context context, int resid, String color) {
        long thisCol=Long.decode(color)+4278190080L;
        int useColour=(int)thisCol;
        Drawable mDrawable = context.getResources().getDrawable(resid, null);
        mDrawable.setColorFilter(new PorterDuffColorFilter(useColour, PorterDuff.Mode.MULTIPLY));
        return mDrawable;
    }*/

    /**
     * changeImageViewTintColor - changes the color of an imageview
     * @param iv the imageview
     * @param color the color you want
     */
    public static void changeImageViewTintColor(ImageView iv, int color) {
        iv.setColorFilter(ContextCompat.getColor(iv.getContext(), color), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    public static Palette getPaletteFromImage(Bitmap bitmap) {
        return Palette.from(bitmap).generate();
    }

    public static Palette getPalatteFromUrl(String url) throws IOException {
        URL url_value = new URL(String.valueOf(url));
        Bitmap mIcon1 = BitmapFactory.decodeStream(url_value.openConnection().getInputStream());
        return Palette.from(mIcon1).generate();
    }

    public static int getDominanteColorFromUrl(String url, int defaultColor) throws IOException {
        URL url_value = new URL(String.valueOf(url));
        Bitmap mIcon1 = BitmapFactory.decodeStream(url_value.openConnection().getInputStream());
        return Palette.from(mIcon1).generate().getDominantColor(defaultColor);
    }

    public static Palette getPaletteFromDrawable(Context context, int resid) {
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), resid);
        return Palette.from(icon).generate();
    }

    public static int getDominanteColorFromDrawable(Context context, int resid, int defaultColor) {
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), resid);
        return Palette.from(icon).generate().getDominantColor(defaultColor);
    }

}
