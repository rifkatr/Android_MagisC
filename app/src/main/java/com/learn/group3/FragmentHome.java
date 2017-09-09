package com.learn.group3;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentHome extends Fragment{

    String userName = "", ava = "";
    TextView showUserName;
    ImageView showAva;

    public static FragmentHome newInstance() {
        return new FragmentHome();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        Intent getUser = getActivity().getIntent();
        userName = getUser.getStringExtra("edname");
        ava = getUser.getStringExtra("gender");
        showUserName = (TextView) view.findViewById(R.id.username);
        showAva = (ImageView) view.findViewById(R.id.ava);
        showUserName.setText(userName);
        if(ava.equals("Female")){
            showAva.setBackground(getResources().getDrawable(R.drawable.female));
        }else{
            showAva.setBackground(getResources().getDrawable(R.drawable.male));
        }



        return view;
    }
}
