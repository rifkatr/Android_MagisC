package com.learn.group3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class fragmentReading extends Fragment implements View.OnClickListener{

    MediaPlayer sound;

    public static fragmentReading newInstance() {
        return new fragmentReading();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reading,container,false);

        ImageView play = (ImageView) view.findViewById(R.id.soundPlay);
        Button buttonExcercise = (Button) view.findViewById(R.id.btnExercise);
        Button buttonVocab = (Button) view.findViewById(R.id.btnVocab);

        buttonExcercise.setOnClickListener(this);
        buttonVocab.setOnClickListener(this);
        play.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        //      ini detek kalo lagi bersuara harus di matiin dulu
        if(sound != null){
            sound.stop();
        }
//      ini dapetin id yg kita klik

        switch (v.getId()) {
            case R.id.soundPlay:
                // ini kalo button 1 yg di klik
                sound = MediaPlayer.create(getActivity().getApplication(), R.raw.story_satu);
                sound.start();
                break;
            case R.id.btnExercise:
                Intent i = new Intent(getActivity().getApplication(), ExerciseListening.class);
                startActivity(i);
                break;
            case R.id.btnVocab:
                Intent j = new Intent(getActivity().getApplication(), ExerciseListening.class);
                startActivity(j);
                break;
            default:
                break;
        }
    }

}
