package com.learn.group3;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class fragmentWriting extends Fragment implements OnClickListener{

    Button bCheck;
    EditText edSatu, edDua, edTiga, edEmpat, edLima, edEnam;
    TextView akhir, a;
    ImageView next;

    public static fragmentWriting newInstance() {
        return new fragmentWriting();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_writing,container,false);

        bCheck  = (Button) view.findViewById(R.id.btnCheck);
        akhir = (TextView) view.findViewById(R.id.hasil);
        next = (ImageView) view.findViewById(R.id.lain);
        edSatu  = (EditText) view.findViewById(R.id.etSatu);
        edDua  = (EditText) view.findViewById(R.id.etDua);
        edTiga  = (EditText) view.findViewById(R.id.etTiga);
        edEmpat  = (EditText) view.findViewById(R.id.etEmpat);
        edLima  = (EditText) view.findViewById(R.id.etLima);
        edEnam  = (EditText) view.findViewById(R.id.etEnam);

        akhir.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
//      disini tambahin listener onClick nya
        bCheck.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnCheck:
                if(edSatu.getText().toString().equals("f") && edDua.getText().toString().equals("a")
                        && edTiga.getText().toString().equals("h") && edEmpat.getText().toString().equals("r")
                        && edLima.getText().toString().equals("e")&& edEnam.getText().toString().equals("n")){
                    akhir.setText("Richtig");
                    akhir.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
                    akhir.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                }else{
                    akhir.setText("Falsch");
                    akhir.setBackgroundColor(getResources().getColor(R.color.colorWrong));
                    akhir.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.lain:
            default:
                break;
        }
    }
}
