package com.example.chavezgt.chronometer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Chronometer;




public class MainActivity extends ActionBarActivity {
private Chronometer chronometer;
private long pausedTime = 0;
private boolean secondTime = false;
    //for test






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver mReceiver = new ScreenOffReceiver();
        registerReceiver(mReceiver, filter);
        setContentView(R.layout.activity_main);
        Window window = this.getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);


        chronometer = (Chronometer) findViewById(R.id.chronos);
    }

    //Default Options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //Default options
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //On Stop detects if the user turned off the screen or accessed his phone
    //The first option stops the chronometer. The second one started it
    @Override
    protected void onStop() {
        super.onStop();

        if (ScreenOffReceiver.screenOff) {
            // THIS IS WHEN ONRESUME() IS CALLED DUE TO A SCREEN STATE CHANGE
            stopChron(findViewById(R.id.chronos));
        } else {
            // THIS IS WHEN ONRESUME() IS CALLED WHEN THE SCREEN STATE HAS NOT CHANGED
            resumeChron(findViewById(R.id.chronos));

        }
    }

    //Default function
    @Override
    protected void onResume() {
        super.onResume();
    }



    public  void stopChron(View view){

        pausedTime = SystemClock.elapsedRealtime() - chronometer.getBase();
        chronometer.stop();
    }
    public void resumeChron(View view){

        chronometer.setBase(SystemClock.elapsedRealtime() - pausedTime);
        chronometer.start();
    }
    public void goHome(View view){

        Intent homeIntent= new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeIntent);

    }

}
