//package com.example.umair.webview;
//
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.support.v4.app.NotificationCompat;
//
//class Notification_receiver extends BroadcastReceiver{
//
//
//        public void onReceive(Context context, Intent intent){
//
//            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//
//            Intent repeating_intent = new Intent(context, Repeating_activity.class);
//            repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//            PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
//
//            Notification notification = builder.setContentTitle("Daily Survey Reminder!")
//                    .setContentText("New Survey Available")
//                    .setTicker("New Message Alert")
//                    .setAutoCancel(true)
//                    .setSmallIcon(R.mipmap.ic_launcher_round)
//                    .setContentIntent(pendingIntent).build();
//
//            notificationManager.notify(0,notification);
//
//        }
//
//
//}
