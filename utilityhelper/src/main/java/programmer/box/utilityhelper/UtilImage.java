package programmer.box.utilityhelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
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

    /**
     * changeImageViewTintColor - changes the color of an imageview
     * @param iv the imageview
     * @param color the color you want
     */
    public static void changeImageViewTintColor(ImageView iv, int color) {
        iv.setColorFilter(ContextCompat.getColor(iv.getContext(), color), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    public static void changeDrawableColor(Drawable d, int color) {
        d.mutate().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
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

    /**
     * lighter - Lightens a color by a given factor. TAKEN FROM STACKOVERFLOW <a href="https://stackoverflow.com/a/28058035">https://stackoverflow.com/a/28058035</a>
     *
     * @param color
     *            The color to lighten
     * @param factor
     *            The factor to lighten the color. 0 will make the color unchanged. 1 will make the
     *            color white.
     * @return lighter version of the specified color.
     */
    public static int lighter(int color, float factor) {
        int red = (int) ((Color.red(color) * (1 - factor) / 255 + factor) * 255);
        int green = (int) ((Color.green(color) * (1 - factor) / 255 + factor) * 255);
        int blue = (int) ((Color.blue(color) * (1 - factor) / 255 + factor) * 255);
        return Color.argb(Color.alpha(color), red, green, blue);
    }

    /**
     * Returns darker version of specified <code>color</code>. TAKEN FROM STACKOVERFLOW <a href="https://stackoverflow.com/a/26554179">https://stackoverflow.com/a/26554179</a>
     */
    public static int darker (int color, float factor) {
        int a = Color.alpha( color );
        int r = Color.red( color );
        int g = Color.green( color );
        int b = Color.blue( color );

        return Color.argb( a,
                Math.max( (int)(r * factor), 0 ),
                Math.max( (int)(g * factor), 0 ),
                Math.max( (int)(b * factor), 0 ) );
    }

}
