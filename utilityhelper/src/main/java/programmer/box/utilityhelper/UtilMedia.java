package programmer.box.utilityhelper;

import android.app.MediaRouteActionProvider;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.media.MediaControlIntent;
import android.support.v7.media.MediaRouteSelector;

/**
 * Created by Jacob on 10/5/17.
 */

public class UtilMedia {

    public static MediaRouteSelector mediaRouter() {
        // Create a route selector for the type of routes your app supports.
        MediaRouteSelector mSelector = new MediaRouteSelector.Builder()
                // These are the framework-supported intents
                .addControlCategory(MediaControlIntent.CATEGORY_REMOTE_PLAYBACK)
                .build();
        return mSelector;
    }

}
