package com.androidexercises.ihuexercises.set02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.androidexercises.ihuexercises.R;


public class CalculatorActivity extends AppCompatActivity {
    CalculatorOperationsListener calcFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        CalculatorLayoutFragment frag = new CalculatorLayoutFragment();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.fragCont, frag);
        trans.addToBackStack(null);
        trans.commit();
        calcFrag = frag;
    }

    public void appendOperandCK(View v) {
        calcFrag.appendOperandCK(v);
    }

    public void appendOperatorCK(View v) {
        calcFrag.appendOperatorCK(v);
    }

    public void appendCommaCK(View v) {
        calcFrag.appendCommaCK(v);
    }

    public void clear(View v) {
        calcFrag.clear(v);
    }

    public void delChar(View v) {
        calcFrag.delChar(v);
    }

    public void calculateCK(View v) {
        calcFrag.calculateCK(v);
    }

    public void powerCalc(View v) {
        calcFrag.powerCalc(v);
    }
}
