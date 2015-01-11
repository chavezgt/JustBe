package com.example.chavezgt.chronometer; /**
 * Created by chavezgt on 1/9/15.
 */
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Toast;

import com.example.chavezgt.chronometer.MainActivity;

public class ScreenOffReceiver
        extends BroadcastReceiver{

    //Needs to be static to be accessed from other classes
    static boolean  screenOff;

    //Reads if screen has been turned On or Off
    @Override
    public void onReceive
    (final Context context, Intent intent){
        //Screen is turned off
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            screenOff = true;
        }
        //Screen is turned on
        else if(intent.getAction().equals(Intent.ACTION_SCREEN_ON))

            if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
                screenOff = false;
            }

        //Create an intent and start the service
        Intent i = new Intent(context, ReadScreenService.class);
        context.startService(i);

    }
}