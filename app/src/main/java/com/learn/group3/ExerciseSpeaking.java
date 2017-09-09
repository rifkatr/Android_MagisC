package com.learn.group3;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Locale;

public class ExerciseSpeaking extends AppCompatActivity implements View.OnClickListener {

    String[] answerArray = {
            "book",
            "chair",
            "desk"
    };

    TextView result, result2, question;
    ImageView speechButton, nextIcon;
    int cek=0;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    protected void setQuestion(){
        switch (cek) {
            case 0:
                question.setText("Book");
                break;
            case 1:
                question.setText("Chair");
                break;
            case 2:
                question.setText("Desk");
                break;
            default:
                break;
        }

    } //setQuestion

    protected void visible(boolean status){
        if(status){
            nextIcon.setVisibility(View.VISIBLE);
        }
        result2.setVisibility(View.VISIBLE);
    }

    protected void invisible(){
        nextIcon.setVisibility(View.INVISIBLE);
        result2.setVisibility(View.INVISIBLE);
    }

    protected void trueAnswer(){
        result2.setText("Correct");
        result2.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
    }

    protected void falseAnswer(){
        result2.setText("Incorrect");
        result2.setBackgroundColor(getResources().getColor(R.color.colorWrong));
    }

    protected void checkAnswer(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_speaking);

        question = (TextView) findViewById(R.id.title);
        nextIcon = (ImageView) findViewById(R.id.next);
        result = (TextView) findViewById(R.id.jawab);
        result2 = (TextView) findViewById(R.id.hasil);
        speechButton = (ImageView) findViewById(R.id.btnMic);

        invisible();
        setQuestion();

        speechButton.setOnClickListener(this);
        result.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMic:
                inputSpeechDialog();
                break;
            case R.id.next:
                cek++;
                if(cek > 2){
                    cek = 0;
                    finish();
                }else{
                    invisible();
                    setQuestion();
                }
                break;
            default:
                break;
        }
    }

    //fungsi untuk SpeechToText

    //function untuk menampilkan dialog google speech input
    private void inputSpeechDialog(){
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //dibawah ini adalah settingan untuk memanggil google speech input
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "de-DE");
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.sesuatu));

        //ini adalah perintah untuk mengeksekusi intent dan memunculkan dialog speech input google
        try {
            startActivityForResult(i, REQ_CODE_SPEECH_INPUT);
        }catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), getString(R.string.tidaksupport), Toast.LENGTH_SHORT).show();
        }
    } //inputSpeechDialog

    //ni function ketika menerima hasil dari dialog google speech input
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if(resultCode == RESULT_OK && null != data){ //kalau resultCode nya sama dengan OK
                    //masukkan hasil suara kedalam array (biar bisa lebih dari 1 kata)
                    ArrayList<String> hasil = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //masukkan hasil array ke text
                    result.setText(hasil.get(0));
                    if(result.getText().toString().equals(answerArray[cek])){
                        visible(true);
                        trueAnswer();
                    }else{
                        invisible();
                        visible(false);
                        falseAnswer();
                    }
                }
                break;
            }
        }
    } //onActivityResult


} //class exerciseSpeaking
