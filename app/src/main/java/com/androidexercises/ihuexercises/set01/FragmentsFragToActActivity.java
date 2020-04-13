package com.androidexercises.ihuexercises.set01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.androidexercises.ihuexercises.R;

public class FragmentsFragToActActivity extends AppCompatActivity implements FragmentsFragToActMainFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_frag_to_act);
    }

    @Override
    public void onMessageSend(String message) {
        TextView outputCont = findViewById(R.id.outputCont);
        outputCont.setText(message);
    }


}
