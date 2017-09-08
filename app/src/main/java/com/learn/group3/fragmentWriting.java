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
import android.widget.TextView;

public class fragmentWriting extends Fragment implements OnClickListener{

    Button bCheck;
    EditText edSatu, edDua, edTiga, edEmpat;
    TextView akhir, a;

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
        edSatu  = (EditText) view.findViewById(R.id.etSatu);
        edDua  = (EditText) view.findViewById(R.id.etDua);
        edTiga  = (EditText) view.findViewById(R.id.etTiga);
        edEmpat  = (EditText) view.findViewById(R.id.etEmpat);
        a = (TextView) view.findViewById(R.id.tes);

        akhir.setVisibility(View.INVISIBLE);
//      disini tambahin listener onClick nya
        bCheck.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        String jawabA = "";
        String jawabB = "";
        String jawabC = "";
        String jawabD = "";

        jawabA = edSatu.getText().toString();
        jawabB = edDua.getText().toString();
        jawabC = edTiga.getText().toString();
        jawabD = edEmpat.getText().toString();

        a.setText(jawabA+jawabB+jawabC+jawabD);

        akhir.setVisibility(View.VISIBLE);

    }
}
