package com.example.umair.webview.Service;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
/**
 * Created by umair on 4/4/18.
 */

public class MyFirebaseIdService  extends FirebaseInstanceIdService{

    public void onTokenRefresh(){
        super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        sendToServer(token);
    }

    private void sendToServer(String token) {
    }
}
