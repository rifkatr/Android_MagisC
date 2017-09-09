package com.learn.group3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.view.View;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener{

    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        fab = (FloatingActionButton) findViewById(R.id.Quis);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, FragmentHome.newInstance()).commit();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemReselectedListener(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, fragmentQuiz.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId())
        {
            case R.id.navigation_home: fragment = FragmentHome.newInstance();
                break;
            case R.id.navigation_listening: fragment = fragmentListening.newInstance();
                break;
            case R.id.navigation_speaking :fragment = fragmentSpeaking.newInstance();
                break;
            case R.id.navigation_writing : fragment = fragmentWriting.newInstance();
                break;
            case R.id.navigation_reading : fragment = fragmentReading.newInstance();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.flContent,fragment).commit();
    }
}
