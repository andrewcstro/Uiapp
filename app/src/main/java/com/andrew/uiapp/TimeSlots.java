package com.andrew.uiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class TimeSlots extends AppCompatActivity {
    //ConstraintLayout newLayoutTimeSlots
    ImageView IvNewTimerSlots;
    TextView TvNewNomeOrario;
    TextView TvNewOrario;
    Switch newSwitchOrario;
    int id=R.id.layoutTimeSlots;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slots);
        ImageView IvAddButton=findViewById(R.id.IvAddButton);
        IvAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLayoutTimeSlots();
            }
        });
    }
    public void addLayoutTimeSlots(){


        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layoutTimeSlots);

        layout.setId(SetIdLayout(id,R.id.layoutTimeSlots));
        IvNewTimerSlots=findViewById(R.id.IvTimerSlots);
        TvNewNomeOrario=findViewById(R.id.TvNomeOrario);
        TvNewOrario=findViewById(R.id.TvOrario);
        newSwitchOrario=findViewById(R.id.SwitchOrario);
        layout.addView(TvNewNomeOrario);
        layout.addView(IvNewTimerSlots);
        layout.addView(TvNewOrario);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layout);
        constraintSet.connect(layout.getId(),ConstraintSet.START,R.id.layoutHeader,ConstraintSet.START,0);
        constraintSet.connect(layout.getId(),ConstraintSet.TOP,GetIdLayout(id),ConstraintSet.BOTTOM,0);
        constraintSet.applyTo(layout);
        ConstraintLayout.LayoutParams newLayoutParams = (ConstraintLayout.LayoutParams) layout.getLayoutParams();
        newLayoutParams.topMargin = 22;
        newLayoutParams.leftMargin = 15;
        newLayoutParams.rightMargin = 15;
        layout.setLayoutParams(newLayoutParams);
    }

    public int SetIdLayout(int id,int R_id){

        if(id!=R_id){

            id=+c;
            c++;
        }
        return id;
    }
    public int GetIdLayout(int id){
        if(id!=R.id.layoutTimeSlots) return id;
        else return id+c;

    }
}
