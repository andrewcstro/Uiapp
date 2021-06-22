package com.andrew.uiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.MotionEventCompat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ImageView IvTime;
    private ImageView IvAccount;
    public TextView tHello;
    public BottomNavigationView bottomNavigation;
    int control=0;
    boolean controlOnTouch=true;
    int LAUNCH_ACCOUNT_ACTIVITY = 1;
    String nameUser="c";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tHello=findViewById(R.id.textUsername);

        //Bundle extras= getIntent().getExtras();
        //if(extras!=null){
          //  String nameUser=extras.getString("name");
          //  tHello.setText(nameUser);
        //}
        bottomNavigation = findViewById( R.id.bottomNavigationView);
       bottomNavigation.setItemOnTouchListener(R.id.menuAccount, new View.OnTouchListener() {


          @Override
          public boolean onTouch(View v, MotionEvent event)
          {
              int action = MotionEventCompat.getActionMasked(event);
              if(action==MotionEvent.ACTION_UP){openAccountActivity();}
              //apro la nuova activity al rilascio della pressione del dito, ignoro la prima pressione.
              return  true;

          }


          }

          );


        IvTime= findViewById(R.id.IvTime);
        IvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimeActivity();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("nom",Context.MODE_PRIVATE);
        String name=sharedPref.getString("name","utente");
        Log.i("sta andando",name);
        tHello.setText(name);

    }

    public void openTimeActivity(){
        Intent intentTime = new Intent(this,TimeSlots.class);

        startActivity(intentTime);
    }

    public void  openAccountActivity(){


            Intent intentAccount = new Intent(this, Account.class);
            startActivityForResult(intentAccount,LAUNCH_ACCOUNT_ACTIVITY);



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){





                // connect start and end point of views, in this case top of child to top of parent.

                // ... similarly add other constraints


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
            }
        }

    }

    public int SetIdLayout(int id,int R_id){

        if(id!=R_id){
            id=id+ control;
            control++;
        }
        return id;
    }
    public int GetIdLayout(int id){
        if(id!=R.id.layoutTimeSlots) return id;
        else return id+ control;

    }


}