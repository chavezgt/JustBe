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

    //Instance Variables 1 =true
    static boolean  screenOff;




    //When it recceives it will send a message to service
    @Override
    public void onReceive
    (final Context context, Intent intent){

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            //DO SOMETHINGequals(Intent
            screenOff = true;
        }else if(intent.getAction().equals(Intent.ACTION_SCREEN_ON))

            if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
                //dO SOMETHING ELSE
                screenOff = false;
            }
        //Create Message Object and append Action screen
        Intent i = new Intent(context, ReadScreenService.class);
        i.putExtra("screen_state", screenOff);
        context.startService(i);

    }
}