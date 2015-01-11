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

    private Looper mServiceLooper;
    /** indicates how to behave if the service is killed */
    int mStartMode;
    /** interface for clients that bind */
    IBinder mBinder = new LocalBinder();
    /** indicates whether onRebind should be used */
    boolean mAllowRebind;

    public class LocalBinder extends Binder {
      //  ReadScreenService  getService(){

     //   }
    }


     @Override
     public void onCreate(){
         super.onCreate();
         //REGISTER A HANDLER
         IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
         filter.addAction(Intent.ACTION_SCREEN_OFF);
         BroadcastReceiver mReceiver = new ScreenOffReceiver();
         registerReceiver(mReceiver, filter);
     }

    /** The service is starting, due to a call to startService() */
    @Override
    public int  onStartCommand(Intent intent, int flags, int startId){
        System.out.println("ME LA PELAS");
        //Deprecated Mode
       /* if (ScreenOffReceiver.wasScreenOn) {
            // THIS IS THE CASE WHEN ONPAUSE() IS CALLED BY THE SYSTEM DUE TO A SCREEN STATE CHANGE
            System.out.println("SCREEN TURNED OFF");
        } else {
        }
         if (!ScreenOffReceiver.wasScreenOn) {
            // THIS IS WHEN ONRESUME() IS CALLED DUE TO A SCREEN STATE CHANGE
            System.out.println("SCREEN TURNED ON");
           // resumeChron(findViewById(R.id.chronos));


        } else {
            // THIS IS WHEN ONRESUME() IS CALLED WHEN THE SCREEN STATE HAS NOT CHANGED
        } */
        boolean screenOn = ScreenOffReceiver.screenOff;
        if(screenOn){
            System.out.println("Apagada");
            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            i.putExtra("com.example.chavezgt.chronometer.MESSAGE", true);
            //helloo
            this.startActivity(i);

        }else {

        }

        return START_STICKY;

    }

    public void receiveMsg() {

    }
        @Override
    public IBinder onBind(Intent intent){
        //return null
        return null;

    }
    @Override
    public void onDestroy(){

    }
}
