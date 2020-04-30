package com.androidexercises.ihuexercises.set02;

import android.view.View;

public interface CalculatorOperationsListener {
    public void appendOperandCK(View v);

    public void appendOperatorCK(View v);

    public void appendCommaCK(View v);

    public void clear(View v);

    public void delChar(View v);

    public void calculateCK(View v);

    public void powerCalc(View v);

}
