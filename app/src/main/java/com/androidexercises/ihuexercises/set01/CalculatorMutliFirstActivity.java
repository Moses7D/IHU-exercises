package com.androidexercises.ihuexercises.set01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.androidexercises.ihuexercises.R;

public class CalculatorMutliFirstActivity extends AppCompatActivity {
    public static final String EXTRA_SUM = "com.androidexercises.teitheexercises.set01.SUM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_mutli_first);
    }

    public void addAndSend(View v) {
        EditText oper01 = findViewById(R.id.operand01);
        EditText oper02 = findViewById(R.id.operand02);
        double num01=0.0, num02=0.0, addition=0.0;
        try{
            num01 = Double.parseDouble(oper01.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            num02 = Double.parseDouble(oper02.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        double addedN = num01+num02;
        Intent calcSexondInt = new Intent(this, CalculatorMutliSecondActivity.class);
        calcSexondInt.putExtra(EXTRA_SUM,addedN);
        startActivity(calcSexondInt);
    }
}
