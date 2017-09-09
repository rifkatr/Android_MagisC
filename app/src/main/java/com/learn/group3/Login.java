package com.learn.group3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    Button bstart;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etName = (EditText)findViewById(R.id.edName);
        bstart = (Button)findViewById(R.id.bStart);
        rg = (RadioGroup)findViewById(R.id.rgGender);

        bstart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("edname",etName.getText().toString());
        startActivity(intent);
        finish();
    }
}