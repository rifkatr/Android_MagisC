package com.learn.group3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseListening extends AppCompatActivity implements View.OnClickListener {

    String[] answerArray = {
            "book",
            "chair",
            "desk"
    };

    ImageView playSound, nextIcon;
    Button checkButton;
    EditText inputAnswer;
    TextView result, titleExercise;
    MediaPlayer sound;
    int cek = 0;

    protected void startSound(){
        if(sound != null){
            sound.stop();
        }
        switch (cek) {
            case 0:
                sound = MediaPlayer.create(ExerciseListening.this, R.raw.buku);
                sound.start();
                break;
            case 1:
                sound = MediaPlayer.create(ExerciseListening.this, R.raw.kamus);
                sound.start();
                break;
            case 2:
                sound = MediaPlayer.create(ExerciseListening.this, R.raw.buku);
                sound.start();
                break;
            default:
                break;
        }

    }

    protected void setTitle() {
        titleExercise.setText("Übung : " + String.valueOf(cek + 1));
    }

    protected void visible(boolean status){
        if(status){
            nextIcon.setVisibility(View.VISIBLE);
        }
        result.setVisibility(View.VISIBLE);
    }

    protected void invisible(){
        nextIcon.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
    }

    protected void trueAnswer(){
        result.setText("Richtig");
        result.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
    }

    protected void falseAnswer(){
        result.setText("Falsch");
        result.setBackgroundColor(getResources().getColor(R.color.colorWrong));
    }

    protected void checkAnswer(){
        if(inputAnswer.getText().toString().equals(answerArray[cek])){
            visible(true);
            trueAnswer();
        }else{
            inputAnswer.setText("");
            invisible();
            visible(false);
            falseAnswer();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_listening);

        playSound = (ImageView) findViewById(R.id.play_sound);
        nextIcon = (ImageView) findViewById(R.id.next_excercise);
        result = (TextView) findViewById(R.id.hasil);
        inputAnswer = (EditText) findViewById(R.id.answer);
        checkButton = (Button) findViewById(R.id.btnCheck);
        titleExercise = (TextView) findViewById(R.id.title);

        invisible();
        setTitle();


        playSound.setOnClickListener(this);
        checkButton.setOnClickListener(this);
        nextIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play_sound:
                startSound();
                break;
            case R.id.btnCheck:
                checkAnswer();
                break;
            case R.id.next_excercise:
                cek++;
                inputAnswer.setText("");
                if(cek > 2){
                    cek = 0;
                    finish();
                }else{
                    invisible();
                    setTitle();
                }
            default:
                break;
        }
    }
}
