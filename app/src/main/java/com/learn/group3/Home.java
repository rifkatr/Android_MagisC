package com.learn.group3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v4.app.Fragment;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, fragmentListening.newInstance()).commit();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemReselectedListener(this);
    }
    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId())
        {
            case R.id.navigation_listening: fragment = fragmentListening.newInstance();
                break;
            case R.id.navigation_speaking :fragment = fragmentSpeaking.newInstance();
                break;
            case R.id.navigation_writing : fragment = fragmentWriting.newInstance();
                break;
            case R.id.navigation_reading : fragment = fragmentReading.newInstance();
                break;
            case R.id.navigation_quiz : fragment = fragmentQuiz.newInstance();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.flContent,fragment).commit();
    }
}
