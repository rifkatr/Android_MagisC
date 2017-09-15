package com.learn.group3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by rizalsidikp on 10/09/17.
 */

public class QuizLevelOne extends AppCompatActivity implements View.OnClickListener {

    String[] jawaban = {
            "Fliegen", "Fahren"
    };

    RadioGroup soalSatu, soalDua;
    RadioButton jawab1, jawab2;
    Button selesai;

    int benar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_level_one);

        soalSatu = (RadioGroup) findViewById(R.id.soal_satu);
        soalDua = (RadioGroup) findViewById(R.id.soal_dua);

        selesai = (Button) findViewById(R.id.hasilJawaban);

        selesai.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.hasilJawaban:
                benar = 0;
                int hasilSoalSatu = soalSatu.getCheckedRadioButtonId();
                int hasilSoalDua = soalDua.getCheckedRadioButtonId();
                jawab1 = (RadioButton) findViewById(hasilSoalSatu);
                jawab2 = (RadioButton) findViewById(hasilSoalDua);
                String[] hasilJawab = {
                        hasilSoalSatu == -1 ? null : jawab1.getText().toString(),
                        hasilSoalDua == -1 ? null : jawab2.getText().toString()
                };
                for(int x = 0; x < hasilJawab.length; x++){
                    if(jawaban[x].equals(hasilJawab[x])){
                        benar++;
                    }
                }
                Toast.makeText(QuizLevelOne.this, "Richtig : " + String.valueOf(benar), Toast.LENGTH_SHORT).show();

                break;
            default:
                break;
        }

    }
}
