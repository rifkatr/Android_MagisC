package com.learn.group3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    Button bstart;
    RadioGroup rg;
    RadioButton cMale, cFemale;
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etName = (EditText)findViewById(R.id.edName);
        bstart = (Button)findViewById(R.id.bStart);
        rg = (RadioGroup)findViewById(R.id.rgGender);
        cMale = (RadioButton) findViewById(R.id.rbMale);
        cFemale = (RadioButton) findViewById(R.id.rbFemale);

        cMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "Male";
            }
        });

        cFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "Female";
            }
        });

        bstart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (!cMale.isChecked() && !cFemale.isChecked()){
            Toast.makeText(Login.this, "You Must Choose a gender", Toast.LENGTH_SHORT).show();
        }else if(etName.getText().toString().trim().equals("")){
            Toast.makeText(Login.this, "You Must Insert a Name", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, Home.class);
            intent.putExtra("gender", gender);
            intent.putExtra("edname",etName.getText().toString());
            startActivity(intent);
            finish();
        }
    }
}