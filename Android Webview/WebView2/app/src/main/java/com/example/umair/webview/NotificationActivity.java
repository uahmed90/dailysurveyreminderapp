package com.example.umair.webview;

/**
 * Created by umair on 4/22/18.
 */

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;


public class NotificationActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
         wv.loadUrl("http://testingdb-a8cd7.firebaseapp.com");

    }
    protected void onClick(Bundle savedInstanceState){
        setContentView(R.layout.activity_main);
        wv.loadUrl("http://www.testingdb-a8cd7.firebaseapp.com");


    }


}
