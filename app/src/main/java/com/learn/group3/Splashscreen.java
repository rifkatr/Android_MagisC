package com.learn.group3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends Activity{
    //set waktu lama splash screen
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get the view from splash.xml
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splashscreen.this, Login.class);
                //start MainActivity.class
                startActivity(i);

                //close Splashscreen.class
                finish();
            }
        }, splashInterval);
    }
}
