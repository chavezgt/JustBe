package com.example.chavezgt.chronometer;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.app.Service;
import android.view.Display;

/**
 * Created by chavezgt on 1/10/15.
 */

public class ReadScreenService extends Service {
    public final static String EXTRA_MESSAGE = "com.example.chavezgt.chronometer..MESSAGE";

    //Default values
    private Looper mServiceLooper;
    /** indicates how to behave if the service is killed */
    int mStartMode;
    /** indicates whether onRebind should be used */
    boolean mAllowRebind;
    BroadcastReceiver mReceiver = new ScreenOffReceiver();



    @Override
     public void onCreate(){
         super.onCreate();
         //Register filter and receiver for Screen OffReceiver
         IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
         filter.addAction(Intent.ACTION_SCREEN_OFF);
         registerReceiver(mReceiver, filter);
     }

    //This executes each time the service is called by ScreenOffReceiver
    @Override
    public int  onStartCommand(Intent intent, int flags, int startId){

        //Checks if there has been a broadcast for a change in the state of the screen
        boolean screenOff = ScreenOffReceiver.screenOff;
        //if On: call startActivity to execute it. ACTIVITY NEEDS TO BE SET TO LAUNCHMODE SINGLE TASK IN MANIFEST
        if(screenOff){
            //Create intent, send necessary flags and start
            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            this.startActivity(i);
        }

        return START_STICKY;

    }

        @Override
    public IBinder onBind(Intent intent){
        //return null
        return null;

    }

    //Needs to unregister the receiver
    @Override
    public void onDestroy(){
        unregisterReceiver(mReceiver);
    }
}
