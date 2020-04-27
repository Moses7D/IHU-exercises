package com.androidexercises.ihuexercises.set01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.androidexercises.ihuexercises.R;

public class AdditionMutliVSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_mutli_second);
        TextView output;
        output = findViewById(R.id.outputCont);
        Intent startingInt = getIntent();
        output.setText(Double.toString(startingInt.getDoubleExtra(AdditionMutliVFirstActivity.EXTRA_SUM, 0.0)));
    }
}
