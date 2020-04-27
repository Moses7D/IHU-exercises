package com.androidexercises.ihuexercises.set02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.androidexercises.ihuexercises.R;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.Expression;

public class CalculatorActivity extends AppCompatActivity {

    EditText equation;
    TextView output;
    String supportedOperators;
    Expression formula;
    boolean operatorPlaced, operandPlaced, enabled;
    TableLayout calculator;
    Button debugB;
    ImageView bDel;

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
        output = findViewById(R.id.output);
        String[] operatorsStrings = getResources().getStringArray(R.array.supportedOperators);
        supportedOperators = "";
        for (int i = 0; i < operatorsStrings.length; i++) {
            supportedOperators += operatorsStrings[i].charAt(0);
        }
        operatorPlaced = true;
        operandPlaced = false;
        enabled = true;
        calculator = findViewById(R.id.calculator);
        debugB = findViewById(R.id.Bdebug);
        debugB.setVisibility(Button.INVISIBLE);
        bDel = findViewById(R.id.BDel);
    }

    public void debugOperations(View v) {
        /*
        Log.d("positions", "Start: " + equation.getSelectionStart() + " || End: " + equation.getSelectionEnd());
        Log.d("lengths", "Length: " + equation.getText().length());
         */
    }
/*
    public boolean onKeyDown(int key, KeyEvent keyEvent) {
        Log.d("detect", "Key down");
        return false;
    }

    public boolean onKeyUp(int key, KeyEvent keyEvent){
        Log.d("detect", "Key up");
        switch (key) {
            case KeyEvent.KEYCODE_0:
            case KeyEvent.KEYCODE_NUMPAD_0:
                Log.d("detect", "Key pressed: 0");
                appendOperandAll("0");
                return true;
            case KeyEvent.KEYCODE_1:
            case KeyEvent.KEYCODE_NUMPAD_1:
                Log.d("detect", "Key pressed: 1");
                appendOperandAll("1");
                return true;
            case KeyEvent.KEYCODE_2:
            case KeyEvent.KEYCODE_NUMPAD_2:
                Log.d("detect", "Key pressed: 2");
                appendOperandAll("2");
                return true;
            case KeyEvent.KEYCODE_3:
            case KeyEvent.KEYCODE_NUMPAD_3:
                Log.d("detect", "Key pressed: 3");
                appendOperandAll("3");
                return true;
            case KeyEvent.KEYCODE_4:
            case KeyEvent.KEYCODE_NUMPAD_4:
                Log.d("detect", "Key pressed: 4");
                appendOperandAll("4");
                return true;
            case KeyEvent.KEYCODE_5:
            case KeyEvent.KEYCODE_NUMPAD_5:
                Log.d("detect", "Key pressed: 5");
                appendOperandAll("5");
                return true;
            case KeyEvent.KEYCODE_6:
            case KeyEvent.KEYCODE_NUMPAD_6:
                Log.d("detect", "Key pressed: 6");
                appendOperandAll("6");
                return true;
            case KeyEvent.KEYCODE_7:
            case KeyEvent.KEYCODE_NUMPAD_7:
                Log.d("detect", "Key pressed: 7");
                appendOperandAll("7");
                return true;
            case KeyEvent.KEYCODE_8:
            case KeyEvent.KEYCODE_NUMPAD_8:
                Log.d("detect", "Key pressed: 8");
                appendOperandAll("8");
                return true;
            case KeyEvent.KEYCODE_9:
            case KeyEvent.KEYCODE_NUMPAD_9:
                Log.d("detect", "Key pressed: 9");
                appendOperandAll("9");
                return true;
            case KeyEvent.KEYCODE_PERIOD:
            case KeyEvent.KEYCODE_NUMPAD_DOT:
                Log.d("detect", "Key pressed: .");
                appendCommaAll(".");
                return true;
            case KeyEvent.KEYCODE_PLUS:
            case KeyEvent.KEYCODE_NUMPAD_ADD:
                Log.d("detect", "Key pressed: +");
                appendOperatorAll("+");
                return true;
            case KeyEvent.KEYCODE_MINUS:
            case KeyEvent.KEYCODE_NUMPAD_SUBTRACT:
                Log.d("detect", "Key pressed: -");
                appendOperatorAll("-");
                return true;
            case KeyEvent.KEYCODE_SLASH:
            case KeyEvent.KEYCODE_NUMPAD_DIVIDE:
                Log.d("detect", "Key pressed: /");
                appendOperatorAll("/");
                return true;
            case KeyEvent.KEYCODE_STAR:
            case KeyEvent.KEYCODE_NUMPAD_MULTIPLY:
                Log.d("detect", "Key pressed: *");
                appendOperatorAll("*");
                return true;
            case KeyEvent.KEYCODE_ENTER:
                Log.d("detect", "Key pressed: enter");
                calculate();
                return true;
            default:
                Log.d("detect", "default");
                return super.onKeyUp(key,keyEvent);
        }
    }

 */

    public void appendOperandCK(View v) {
        appendOperandAll(((Button) v).getText().toString());
    }

    public void appendOperandAll(String appendable){
        Log.d("operations", "Operation Called appendOperandAll");
        int start = equation.getSelectionStart();
        int end = equation.getSelectionEnd();
        Log.d("testOperands", "Start: " + start + " || End: " + end);
        operandPlaced = true;
        equation.getText().replace(Math.min(start, end), Math.max(start, end), appendable);
    }

    public void appendOperatorCK(View v) {
        appendOperatorAll(((Button) v).getText().toString());
    }

    public void appendOperatorAll(String appendable) {
        Log.d("operations", "Operation Called appendOperatorAll");
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
        operatorPlaced = true;
        operandPlaced = false;
        equation.getText().replace(lookupStart, lookupEnd, appendable);
    }

    public void appendCommaCK(View v) {
        appendCommaAll(".");
    }

    public void appendCommaAll(String appendable){
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
        equation.getText().insert(equation.getSelectionStart(), appendable);
    }

    public void clear(View v) {
        equation.getText().clear();
    }

    public void delChar(View v) {
        if (equation.getText().length() > 0)
            equation.getText().delete(equation.getSelectionStart() - 1, equation.getSelectionEnd());
    }

    public void calculateCK(View v) {
        calculate();
    }

    public void calculate(){
        String expr = equation.getText().toString();
        double result;
        if (expr.isEmpty()) result = 0;
        else {
            formula = new ExpressionBuilder(expr).build();
            result = formula.evaluate();
        }
        output.setText(Double.toString(result));
    }

    public void powerCalc(View v) {
        for (int i = 0; i < calculator.getChildCount(); i++) {
            TableRow row = (TableRow) calculator.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                View child = row.getChildAt(j);
                if (child instanceof Button)
                    ((Button) child).setEnabled(!enabled);
                else if (child instanceof EditText) {
                    ((EditText) child).setFocusable(!enabled);
                    ((EditText) child).setFocusableInTouchMode(!enabled);
                }
            }
        }
        bDel.setEnabled(!enabled);
        enabled = !enabled;
    }
}
