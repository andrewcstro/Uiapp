package com.andrew.uiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static java.security.AccessController.getContext;

public class Account extends AppCompatActivity {

    EditText etNome,etCognome,etEmail,etNumero;
    Button bttn;
    TextView tv1;
    String name;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        etNome=findViewById(R.id.EtNome);
        bttn=findViewById(R.id.bttnOk);
        tv1=findViewById(R.id.textUsername);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //salvo il nome in sharedpreferences identificato da nome "nom"
                sharedPref = getApplicationContext().getSharedPreferences("nom",Context.MODE_PRIVATE);
                editor = sharedPref.edit();
                name=etNome.getText().toString();
                Log.i("il mio nome",name);
                editor.putString("name",name);
                editor.apply();

                //imposto intento e ritorno alla activity chiamante
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK,returnIntent);
                finish();



            }
        });
        etCognome=findViewById(R.id.EtCognome);
        etEmail=findViewById(R.id.EtEmail);
        etNumero=findViewById(R.id.EtNumero);



    }

}