package com.learn.group3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragmentQuiz extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quiz);

        Button levelOne = (Button) findViewById(R.id.levelSatu);
        levelOne.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.levelSatu:
                Intent i = new Intent(fragmentQuiz.this, QuizLevelOne.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
