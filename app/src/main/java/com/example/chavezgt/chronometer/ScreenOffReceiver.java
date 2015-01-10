package com.example.chavezgt.chronometer; /**
 * Created by chavezgt on 1/9/15.
 */
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.lang.Object;

import com.example.chavezgt.chronometer.MainActivity;

public class ScreenOffReceiver
    extends BroadcastReceiver{
    public static boolean wasScreenOn = true;

    @Override
    public void onReceive
            (Context context, Intent intent){
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            //DO SOMETHING
            wasScreenOn = false;
        }
        if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            //dO SOMETHING ELSE
            wasScreenOn = true;
        }

    }
}
