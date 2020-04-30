package com.androidexercises.ihuexercises.set02;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.androidexercises.ihuexercises.R;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorLayoutFragment extends Fragment implements CalculatorOperationsListener {

    EditText equation;
    TextView output;
    String supportedOperators;
    Expression formula;
    boolean operatorPlaced, operandPlaced, enabled;
    TableLayout calculator;
    Button debugB;
    ImageView bDel;

    public CalculatorLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calculator_layout, container, false);
        equation = v.findViewById(R.id.equation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
            equation.setShowSoftInputOnFocus(false);
        } else { // API 11-20
            equation.setTextIsSelectable(true);
        }
        output = v.findViewById(R.id.output);
        String[] operatorsStrings = getResources().getStringArray(R.array.supportedOperators);
        supportedOperators = "";
        for (int i = 0; i < operatorsStrings.length; i++) {
            supportedOperators += operatorsStrings[i].charAt(0);
        }
        operatorPlaced = true;
        operandPlaced = false;
        enabled = true;
        calculator = v.findViewById(R.id.calculator);
        debugB = v.findViewById(R.id.Bdebug);
        debugB.setVisibility(Button.INVISIBLE);
        bDel = v.findViewById(R.id.BDel);
        return v;
    }

    public void debugOperations(View v) {
        /*
        Log.d("positions", "Start: " + equation.getSelectionStart() + " || End: " + equation.getSelectionEnd());
        Log.d("lengths", "Length: " + equation.getText().length());
         */
    }

    public void appendOperandCK(View v) {
        String appendable = ((Button) v).getText().toString();
        Log.d("operations", "Operation Called appendOperandAll");
        int start = equation.getSelectionStart();
        int end = equation.getSelectionEnd();
        Log.d("testOperands", "Start: " + start + " || End: " + end);
        operandPlaced = true;
        equation.getText().replace(Math.min(start, end), Math.max(start, end), appendable);
    }

    public void appendOperatorCK(View v) {
        String appendable = (((Button) v).getText().toString());
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
        String appendable =".";
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
