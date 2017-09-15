package com.learn.group3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Arip on 10/09/2017.
 */

public class ExerciseReading extends AppCompatActivity implements View.OnClickListener {

    String[] jawaban = {
            "reist",
            "Zug",
            "gehen"
    };

    EditText jawabSatu, jawabDua, jawabTiga;
    Button checkButton;
    TextView result;
    ImageView nextIcon;

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
        if(jawabSatu.getText().toString().equals(jawaban[0]) && jawabDua.getText().toString().equals(jawaban[1])
                && jawabTiga.getText().toString().equals(jawaban[2])){
            visible(true);
            trueAnswer();
        }else{
            invisible();
            visible(false);
            falseAnswer();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_reading);

        jawabSatu = (EditText) findViewById(R.id.jawabSatu);
        jawabDua = (EditText) findViewById(R.id.jawabDua);
        jawabTiga = (EditText) findViewById(R.id.jawabTiga);

        nextIcon = (ImageView) findViewById(R.id.next);
        result = (TextView) findViewById(R.id.hasil);

        checkButton = (Button) findViewById(R.id.btnCheck);
        checkButton.setOnClickListener(this);
        nextIcon.setOnClickListener(this);

        invisible();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCheck:
                checkAnswer();
                break;
            case R.id.next:
                finish();
            default:
                break;
        }
    }
}
