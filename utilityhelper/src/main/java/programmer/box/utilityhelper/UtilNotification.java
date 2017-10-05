package programmer.box.utilityhelper;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by Jacob on 10/3/17.
 */

public class UtilNotification {

    /**
     * createNotificationChannel - creates a notification channel
     * @param context the context
     * @param channelName The user-visible name of the channel.
     * @param channel_description The user-visible description of the channel.
     * @param channel_id The id of the channel.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createNotificationChannel(Context context, String channelName, String channel_description, String channel_id) {

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // The id of the channel.
        String id = channel_id;
        // The user-visible name of the channel.
        CharSequence name = channelName;
        // The user-visible description of the channel.
        String description = channel_description;
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(id, name, importance);
        // Configure the notification channel.
        mChannel.setDescription(description);
        mChannel.enableLights(true);
        // Sets the notification light color for notifications posted to this
        // channel, if the device supports this feature.
        //mChannel.setLightColor(color);
        mChannel.enableVibration(true);
        //mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        mNotificationManager.createNotificationChannel(mChannel);

    }

    /**
     * createNotificationGroup - creates a notification group
     * @param context the context
     * @param group_id The id of the group.
     * @param group_name The user-visible name of the group.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createNotificationGroup(Context context, String group_id, String group_name) {
        // The id of the group.
        String group = group_id;
        // The user-visible name of the group.
        CharSequence name = group_name;
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannelGroup(new NotificationChannelGroup(group, name));
    }

    /**
     * deleteNotificationChannel - deletes a notification channel
     * @param context the context
     * @param channel_id the id of the channel you want deleted
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void deleteNotificationChannel(Context context, String channel_id) {
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // The id of the channel.
        String id = channel_id;
        mNotificationManager.deleteNotificationChannel(id);
    }

    /**
     * sendNotification - sends a notification
     * @param context the context
     * @param smallIconId the icon id for the notification
     * @param title the title
     * @param message the message
     * @param channel_id the channel id
     * @param gotoActivity the activity that will launch when notification is pressed
     * @param notification_id the id of the notification
     */
    public static void sendNotification(Context context, int smallIconId, String title, String message, String channel_id, Class<?> gotoActivity, int notification_id) {
        // The id of the channel.
        String CHANNEL_ID = channel_id;
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(smallIconId)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setChannelId(CHANNEL_ID);
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context, gotoActivity);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your app to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(gotoActivity);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // mNotificationId is a unique integer your app uses to identify the
        // notification. For example, to cancel the notification, you can pass its ID
        // number to NotificationManager.cancel().
        mNotificationManager.notify(notification_id, mBuilder.build());
    }

    /**
     * sendReplyNotification - sends a notification with the reply action
     * @param context the context
     * @param smallIconId the icon id for the notification
     * @param replyIconId the icon id for the reply
     * @param replyActionText the text that shows on the reply action
     * @param replyText the text that shows on the reply bar
     * @param replyId the key that is used when reading the entered text
     * @param title the title
     * @param message the message
     * @param channel_id the channel id
     * @param gotoActivity the activity that will launch when notification is pressed
     * @param notification_id the id of the notification
     */
    public static void sendReplyNotification(Context context, int smallIconId, int replyIconId, String replyActionText, String replyText, String replyId,  String title, String message, String channel_id, Class<?> gotoActivity, int notification_id) {

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your app to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);

        // Key for the string that's delivered in the action's intent.
        String KEY_TEXT_REPLY = replyId;
        String replyLabel = replyText;
        android.support.v4.app.RemoteInput remoteInput = new android.support.v4.app.RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel(replyLabel)
                .build();

        PendingIntent replyPendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                new Intent(context, gotoActivity),
                PendingIntent.FLAG_UPDATE_CURRENT
                );

        // Create the reply action and add the remote input.
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(replyIconId,
                        replyActionText, replyPendingIntent)
                        .addRemoteInput(remoteInput)
                        //.setChannelId(channel_id)
                        .build();

        // The id of the channel.
        String CHANNEL_ID = channel_id;
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(smallIconId)
                        .setContentTitle(title)
                        .addAction(action)
                        .setContentText(message)
                        .setChannelId(CHANNEL_ID);
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context, gotoActivity);

        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(gotoActivity);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // mNotificationId is a unique integer your app uses to identify the
        // notification. For example, to cancel the notification, you can pass its ID
        // number to NotificationManager.cancel().
        mNotificationManager.notify(notification_id, mBuilder.build());
    }

    /**
     * showToast - creates and shows a toast message
     * @param context the context
     * @param message the message
     * @param length the length
     * @return the toast
     */
    public static Toast showToast(Context context, String message, Lengths length) {
        Toast toast = Toast.makeText(context, message, length.length);
        toast.show();
        return toast;
    }

    /**
     * showToast - creates and shows a toast message
     * @param context the context
     * @param message the message
     * @param length the length
     * @return the toast
     */
    public static Toast showToast(Context context, String message, int length) {
        Toast toast = Toast.makeText(context, message, length);
        toast.show();
        return toast;
    }

    /**
     * createToast - creates a toast
     * @param context the context
     * @param message the message
     * @param length the length
     * @return the toast
     */
    public static Toast createToast(Context context, String message, Lengths length) {
        return Toast.makeText(context, message, length.length);
    }

    /**
     * createToast - creates a toast
     * @param context the context
     * @param message the message
     * @param length the length
     * @return the toast
     */
    public static Toast createToast(Context context, String message, int length) {
        return Toast.makeText(context, message, length);
    }

    /**
     * showSnackbar creates and shows a snack bar
     * @param v a view that is needed
     * @param message the message
     * @param length the length
     * @param actionText the action text
     * @param actionClick the action's action
     * @return the snackbar
     */
    public static Snackbar showSnackbar(View v, String message, Lengths length, String actionText, final SnackBarAction actionClick) {
        final Snackbar snackbar = Snackbar.make(v, message, length.length);
        snackbar.setAction(actionText, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClick.snackClick(snackbar);
            }
        }).show();
        return snackbar;
    }

    /**
     * showSnackbar creates and shows a snack bar
     * @param v a view that is needed
     * @param message the message
     * @param length the length
     * @param actionText the action text
     * @param actionClick the action's action
     * @return the snackbar
     */
    public static Snackbar showSnackbar(View v, String message, int length, String actionText, final SnackBarAction actionClick) {
        final Snackbar snackbar = Snackbar.make(v, message, length);
        snackbar.setAction(actionText, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClick.snackClick(snackbar);
            }
        }).show();
        return snackbar;
    }

    /**
     * createSnackbar creates a snack bar
     * @param v a view that is needed
     * @param message the message
     * @param length the length
     * @param actionText the action text
     * @param actionClick the action's action
     * @return the snackbar
     */
    public static Snackbar createSnackbar(View v, String message, Lengths length, String actionText, final SnackBarAction actionClick) {
        final Snackbar snackbar = Snackbar.make(v, message, length.length);
        snackbar.setAction(actionText, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClick.snackClick(snackbar);
            }
        });
        return snackbar;
    }

    /**
     * createSnackbar creates a snack bar
     * @param v a view that is needed
     * @param message the message
     * @param length the length
     * @param actionText the action text
     * @param actionClick the action's action
     * @return the snackbar
     */
    public static Snackbar createSnackbar(View v, String message, int length, String actionText, final SnackBarAction actionClick) {
        final Snackbar snackbar = Snackbar.make(v, message, length);
        snackbar.setAction(actionText, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClick.snackClick(snackbar);
            }
        });
        return snackbar;
    }

    public static void showMenu(Context context, View v, int menuID, PopupMenu.OnMenuItemClickListener onClick) {
        PopupMenu popup = new PopupMenu(context, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(menuID, popup.getMenu());
        popup.setOnMenuItemClickListener(onClick);
        popup.show();
    }

    public static void showMenu(Context context, View v, PopupMenu.OnMenuItemClickListener onClick, String... items) {
        PopupMenu popup = new PopupMenu(context, v);
        for (String item : items) {
            popup.getMenu().add(item);
        }
        popup.setOnMenuItemClickListener(onClick);
        popup.show();
    }

    public interface SnackBarAction {
        public void snackClick(Snackbar snackbar);
    }

    public enum Lengths {

        LONG(Snackbar.LENGTH_LONG), Short(Snackbar.LENGTH_SHORT), INDEFINITE(Snackbar.LENGTH_INDEFINITE);

        int length;

        Lengths(int length) {
            this.length = length;
        }

    }


}
