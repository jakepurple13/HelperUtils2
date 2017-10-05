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
import android.support.v4.app.NotificationCompat;

/**
 * Created by Jacob on 10/3/17.
 */

public class UtilNotification {

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void deleteNotificationChannel(Context context, String channel_id) {
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // The id of the channel.
        String id = channel_id;
        mNotificationManager.deleteNotificationChannel(id);
    }

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

    public static void sendReplyNotification(Context context, int smallIconId, int replyIconId, String replyActionText, String replyText,  String title, String message, String channel_id, Class<?> gotoActivity, int notification_id) {

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your app to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);


        // Key for the string that's delivered in the action's intent.
        String KEY_TEXT_REPLY = "key_text_reply";
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


}
