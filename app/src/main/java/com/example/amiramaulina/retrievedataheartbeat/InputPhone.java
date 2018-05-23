package com.example.amiramaulina.retrievedataheartbeat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class InputPhone extends AppCompatActivity{

    FirebaseAuth auth;
    EditText phone1, phone2, phone3, phone4;
    Button buttonPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phone1 = (EditText)findViewById(R.id.phone1);
        phone2 = (EditText)findViewById(R.id.phone2);
        phone3 = (EditText)findViewById(R.id.phone3);
        phone4 = (EditText)findViewById(R.id.phone4);
        buttonPhone = (Button) findViewById(R.id.buttonPhone);



    }





}
