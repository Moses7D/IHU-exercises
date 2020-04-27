package com.androidexercises.ihuexercises.set01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.androidexercises.ihuexercises.R;

public class AdditionSingleActivity extends AppCompatActivity {
    EditText oper01;
    EditText oper02;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_single);
        oper01 = findViewById(R.id.operand01);
        oper02 = findViewById(R.id.operand02);
        output = findViewById(R.id.outputCont);
    }

    public void add(View v) {
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
        output.setText(Double.toString(addedN));
    }
}
