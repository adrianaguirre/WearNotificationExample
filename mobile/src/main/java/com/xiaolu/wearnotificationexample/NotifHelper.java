package com.xiaolu.wearnotificationexample;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

/**
 * Created by xiaolu on 4/5/15.
 */
public class NotifHelper {
    public static final String EXTRA_EVENT_ID = "eventId";

    public static void buildDemoNotification(Context context) {
        /* Setup various view contents for Notification*/
        int eventId = 0;
        String eventTitle = "Demo title";
        String eventLocation = "Mountain View";

        int notificationId = 001;
        // Build intent for notification content
        Intent viewIntent = new Intent(context, ViewEventActivity.class);
        viewIntent.putExtra(EXTRA_EVENT_ID, eventId);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(context, 0, viewIntent, 0);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(eventTitle)
                        .setContentText(eventLocation)
                        .setContentIntent(viewPendingIntent);

        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

        // Build the notification and issues it with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
