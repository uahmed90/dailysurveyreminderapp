package com.example.umair.webview;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.umair.webview.Common.Config;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    WebView wv;
    private ProgressDialog dialog;
    //private BroadcastReceiver mRegistrationBroadcastReceiver;


    @Override
    public void onBackPressed() {
        if (wv.canGoBack()) {
            wv.goBack();

        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView) findViewById(R.id.wv);



        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY,14);
        cal.add(Calendar.MINUTE, 40);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);


        if (savedInstanceState != null) {
            wv.restoreState(savedInstanceState);
        } else {

            //enable javascript
            wv.getSettings().setJavaScriptEnabled(true);
            wv.setFocusable(true);
            wv.setFocusableInTouchMode(true);
            wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            wv.getSettings().setDomStorageEnabled(true);
            wv.getSettings().setDatabaseEnabled(true);
            wv.getSettings().setAppCacheEnabled(true);
            wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

            //more settings
            wv.getSettings().setUseWideViewPort(true);
            wv.getSettings().setLoadWithOverviewMode(true);
            wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            wv.setBackgroundColor(Color.WHITE);
            wv.setWebViewClient(new myViewClient());
            wv.setWebChromeClient(new WebChromeClient());


            String data = getIntent().getDataString();
            if (Intent.ACTION_VIEW.equals(getIntent().getAction())) {
                wv.loadUrl(data);
            } else {
                wv.loadUrl("http://testingdb-a8cd7.firebaseapp.com");
            }
        }
    }

    public class myViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView v, String url) {
            if (url.contains("testingdb-a8cd7.firebaseapp.com")) {
                v.loadUrl(url);
                CookieManager.getInstance().setAcceptCookie(true);
            } else {
                Uri uri = Uri.parse(url);
                startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Choose browser"));
            }
            return true;

        }

        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);

        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle in) {
        super.onRestoreInstanceState(in);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        wv.saveState(outState);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    BroadcastReceiver mreg = new BroadcastReceiver(){
       @Override
        public void onReceive(Context context, Intent intent){
            if (intent.getAction().equals(Config.STR_PUSH)) {
                String message = intent.getStringExtra(Config.STR_MESSAGE);
                showNotification ("DS Dev", message);
            }
        }
    };

  //  https://testingdb-a8cd7.firebaseapp.com/home.html

    protected void onNewIntent(Intent intent){

        dialog = new ProgressDialog(this);
        if(intent.getStringExtra(Config.STR_KEY)!= null)
        {
            dialog.show();
            dialog.setMessage("Please Wait...");
            wv.loadUrl(intent.getStringExtra(Config.STR_KEY));

        }



    }

    private void showNotification(String title, String message) {
        Intent intent = new Intent(getBaseContext(),MainActivity.class);
        intent.putExtra(Config.STR_KEY,message);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(getBaseContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext());
        builder.setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(contentIntent);
        NotificationManager notificationManager = (NotificationManager)getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }

    protected void onPause(){
        LocalBroadcastManager.getInstance(this).unregisterReceiver((mreg));
        super.onPause();
    }

    protected void onResume(){
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mreg,new IntentFilter("registrationComplete"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mreg,new IntentFilter(Config.STR_PUSH));

    }
}