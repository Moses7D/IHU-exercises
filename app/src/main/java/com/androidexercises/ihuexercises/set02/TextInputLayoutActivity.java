package com.androidexercises.ihuexercises.set02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.androidexercises.ihuexercises.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TextInputLayoutActivity extends AppCompatActivity {
    private TextInputLayout form01A, form01B;
    private TextInputEditText f0101n,f0102pN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        form01A = findViewById(R.id.form01A);
        form01B = findViewById(R.id.form01B);
        f0101n = findViewById(R.id.form01_01name);
        f0102pN = findViewById(R.id.form01_02phNum);
    }

    public void requestFocus(View v){
        if(v.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean val_f0101(){
        Resources res = getResources();
        if(f0101n.getText().toString().trim().isEmpty()) {
            form01A.setError(res.getString(R.string.form01_01nameErr01));
            requestFocus(f0101n);
            return false;
        } else if(f0101n.getText().toString().trim().length() < 3) {
            String formatArg02 = res.getString(R.string.form01_GErr01Sup01C);
            form01A.setError(res.getString(R.string.form01_GErr01,3,formatArg02));
            requestFocus(f0101n);
            return false;
        } else {
            form01A.setErrorEnabled(false);
            return true;
        }
    }

    private boolean val_f0102(){
        Resources res = getResources();
        if(f0102pN.getText().toString().trim().isEmpty()) {
            form01B.setError(res.getString(R.string.form01_02phNumErr01));
            requestFocus(f0102pN);
            return false;
        } else if(f0102pN.getText().toString().trim().length() < 10) {
            String formatArg02 = res.getString(R.string.form01_GErr01Sup02D);
            form01B.setError(res.getString(R.string.form01_GErr01,10,formatArg02));
            requestFocus(f0102pN);
            return false;
        } else {
            form01B.setErrorEnabled(false);
            return true;
        }
    }

    public void submit(View v){
        if(val_f0101() && val_f0102()) {
            hideKeyboard();
            String name = f0101n.getText().toString().trim();
            String num = f0102pN.getText().toString().trim();
            Toast.makeText(getApplicationContext(),name+"\n"+num+"\nOK", Toast.LENGTH_LONG).show();
        }
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it
        View view = this.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
