package com.learn.group3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class playListening extends AppCompatActivity {
    MediaPlayer example1Sound;
    MediaPlayer example2Sound;
    MediaPlayer example3Sound;
    MediaPlayer example4Sound;
    MediaPlayer example5Sound;
    MediaPlayer example6Sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        example1Sound = MediaPlayer.create(this, R.raw.buku);
        example2Sound = MediaPlayer.create(this, R.raw.buku);
        example3Sound = MediaPlayer.create(this, R.raw.buku);
        example4Sound = MediaPlayer.create(this, R.raw.buku);
        example5Sound = MediaPlayer.create(this, R.raw.buku);
        example6Sound = MediaPlayer.create(this, R.raw.buku);

    }

    public void playExampleSound1(View view) {
        example1Sound.start();
    }

    public void playExampleSound2(View view) {
        example2Sound.start();
    }

    public void playExampleSound3(View view) {
        example3Sound.start();
    }

    public void playExampleSound4(View view) {
        example4Sound.start();
    }

    public void playExampleSound5(View view) {
        example5Sound.start();
    }

    public void playExampleSound6(View view) {
        example6Sound.start();
    }
}
}
