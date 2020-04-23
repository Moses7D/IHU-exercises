package com.androidexercises.ihuexercises.set02;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidexercises.ihuexercises.R;

public class CalcActivity extends AppCompatActivity {

    EditText equation;
    String supportedOperators;
    boolean operatorPlaced,operandPlaced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        equation = findViewById(R.id.equation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
            equation.setShowSoftInputOnFocus(false);
        } else { // API 11-20
            equation.setTextIsSelectable(true);
        }
        String[] operatorsStrings = getResources().getStringArray(R.array.supportedOperators);
        supportedOperators = "";
        for (int i = 0; i < operatorsStrings.length; i++) {
            supportedOperators += operatorsStrings[i].charAt(0);
        }
        operatorPlaced=true;
        operandPlaced = false;
    }

    public void showPos(View v) {
        Log.d("positions", "Start: " + equation.getSelectionStart() + " || End: " + equation.getSelectionEnd());
        Log.d("lengths", "Length: " + equation.getText().length());
    }


    public void appendOperand(View v) {
        int start = equation.getSelectionStart();
        int end = equation.getSelectionEnd();
        Log.d("testOperands", "Start: " + start + " || End: " + end);
        String appendable = ((Button) v).getText().toString();
        operandPlaced=true;
        equation.getText().replace(Math.min(start, end), Math.max(start, end), appendable);
    }

    public void appendOperator(View v) {
        int start = equation.getSelectionStart();
        int end = equation.getSelectionEnd();
        int lookupStart, lookupEnd;
        if (equation.length() > 0) {
            lookupStart = Math.max(start - 1, 0);
            if (!supportedOperators.contains(new String(new char[1]).replace('\0', equation.getText().charAt(lookupStart))))
                lookupStart = start;
            lookupEnd = Math.min(end + 1, equation.getText().length());
            if (!supportedOperators.contains(new String(new char[1]).replace('\0', equation.getText().charAt(Math.min(end, equation.getText().length() - 1)))))
                lookupEnd = end;
        } else {
            lookupStart = 0;
            lookupEnd = 0;
        }
        String appendable = ((Button) v).getText().toString();
        operatorPlaced=true;
        operandPlaced=false;
        equation.getText().replace(lookupStart, lookupEnd, appendable);
    }

    public void appendComma(View v) {
        int start = equation.getSelectionStart();
        int end = equation.getSelectionEnd();
        int lookupStart, lookupEnd;
        if (equation.length() > 0) {
            lookupStart = Math.max(start - 1, 0);
            if (equation.getText().charAt(lookupStart) != '.')
                lookupStart = start;

            lookupEnd = Math.min(end + 1, equation.getText().length());
            if (equation.getText().charAt(Math.min(end, equation.getText().length() - 1)) != '.')
                lookupEnd = end;
        } else {
            lookupStart = 0;
            lookupEnd = 0;
        }
        /*if(!operandPlaced) {
            operandPlaced=true;
            equation.append("0.");
        } else if(operatorPlaced) {
            operatorPlaced = false;
            equation.getText().replace(lookupStart, lookupEnd, ".");
        }*/
        equation.getText().insert(equation.getSelectionStart(),".");
    }

    public void clear(View v){
        equation.getText().clear();
    }

    public void delChar(View v){
        if(equation.getText().length() > 0)
            equation.getText().delete(equation.getSelectionStart()-1,equation.getSelectionEnd());
    }

    public void calculate(View v) {
    }
}
