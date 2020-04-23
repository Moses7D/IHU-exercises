package com.androidexercises.ihuexercises.set02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.androidexercises.ihuexercises.R;

public class ColorMixerActivity extends AppCompatActivity {
    CheckBox chM,chC,chY;
    Switch swR,swG,swB;
    TextView output;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_mixer);
        chM = findViewById(R.id.chBM);
        chC = findViewById(R.id.chBC);
        chY = findViewById(R.id.chBY);
        swR = findViewById(R.id.swRed);
        swG = findViewById(R.id.swGr);
        swB = findViewById(R.id.swBl);
        output = findViewById(R.id.colorP);
        res = getApplicationContext().getResources();
        chM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onStateChangedChBox((CheckBox)buttonView,isChecked);
            }
        });
        chC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onStateChangedChBox((CheckBox)buttonView,isChecked);
            }
        });
        chY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onStateChangedChBox((CheckBox)buttonView,isChecked);
            }
        });
    }

    public void onStateChangedChBox(CheckBox chBox, boolean isChecked){
        int ID = getColorIdentifier(chBox.getText().toString());
        Log.d("testColour","The id returned is " + ID);
        int color = res.getColor(ID);
        Log.d("testColour", "Box color is " + color + " " + String.format("#%06X", (0xFFFFFF & color)));
        int bgC = ((ColorDrawable)output.getBackground()).getColor();
        Log.d("testColour", "Current output color is " + bgC + " " + String.format("#%06X", (0xFFFFFF & bgC)));
        if(chBox.isChecked()){
            output.setBackgroundColor(bgC-color);
            Log.d("testColour", "Output color calculated add " + (bgC-color) + " " + String.format("#%06X", (0xFFFFFF & (bgC+color))));
        } else {
            output.setBackgroundColor(bgC-color);
            Log.d("testColour", "Output color calculated subtract " + (bgC-color) + " " + String.format("#%06X", (0xFFFFFF & (bgC-color))));
        }
    }

    public int getColorIdentifier(String IDname) {
        Log.d("testC","ID name gotten is " + IDname.toLowerCase());
        return res.getIdentifier(IDname.toLowerCase(), "color", getApplicationContext().getPackageName());
    }
}
