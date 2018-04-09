package com.example.umair.webview.Service;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.example.umair.webview.Common.Config;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by umair on 4/4/18.
 */

public class FBMessagingService extends FirebaseMessagingService{

    public void onMessageReceived(RemoteMessage remoteMessage){
        handleMessage(remoteMessage.getData().get(Config.STR_KEY));

    }

    private void handleMessage(String message) {
        Intent pushNote = new Intent(Config.STR_PUSH);
        pushNote.putExtra(Config.STR_MESSAGE,message);
        LocalBroadcastManager.getInstance(this).sendBroadcast(pushNote);
    }
}
