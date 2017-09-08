package com.learn.group3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class fragmentSpeaking extends Fragment implements View.OnClickListener{

    // ini sound nya
    MediaPlayer sound;

    public static fragmentSpeaking newInstance() {
        return new fragmentSpeaking();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_speaking,container,false);
        //      get id nya disini, sama kaya kalo pake AppCompactActivity
        ImageView playOne = (ImageView) view.findViewById(R.id.play1);
        ImageView playTwo = (ImageView) view.findViewById(R.id.play2);
        ImageView playThree = (ImageView) view.findViewById(R.id.play3);

//      disini tambahin listener onClick nya

        playOne.setOnClickListener(this);
        playTwo.setOnClickListener(this);
        playThree.setOnClickListener(this);
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
            case R.id.play1:
                // ini kalo button 1 yg di klik
                sound = MediaPlayer.create(getActivity().getApplication(), R.raw.kamus);
                sound.start();
                break;
            case R.id.play2:
                // ini kalo button 2 yg di klik
                sound = MediaPlayer.create(getActivity().getApplication(), R.raw.kamus);
                sound.start();
                break;
            case R.id.play3:
                // ini kalo button 3 yg di klik
                sound = MediaPlayer.create(getActivity().getApplication(), R.raw.kamus);
                sound.start();
                break;
            default:
                break;
        }
    }
}
