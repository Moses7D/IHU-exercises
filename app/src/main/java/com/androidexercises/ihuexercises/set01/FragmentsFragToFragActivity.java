package com.androidexercises.ihuexercises.set01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.androidexercises.ihuexercises.R;

public class FragmentsFragToFragActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.androidexercises.teitheexercises.set01.MESSAGE";
    public static final String TAGS_FIRST_FRAGMENT = "com.androidexercises.teitheexercises.set01.FIST_FRAG";
    public static final String TAGS_SECOND_FRAGMENT="com.androidexercises.teitheexercises.set01.SECOND_FRAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_frag_to_frag);
        if(findViewById(R.id.fragCont) != null) {
            if(savedInstanceState != null) return;
            FragmentsFragToFragFirstFragment mainFrag = new FragmentsFragToFragFirstFragment();
            mainFrag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragCont, mainFrag, TAGS_FIRST_FRAGMENT);
        }
    }

    public void send(View v) {
        FragmentsFragToFragSecondFragment frag = new FragmentsFragToFragSecondFragment();
        EditText container = getSupportFragmentManager().findFragmentById(R.id.fragCont).getView().findViewById(R.id.messageCont);
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_MESSAGE,container.getText().toString());
        frag.setArguments(bundle);
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.fragCont, frag, TAGS_SECOND_FRAGMENT);
        trans.addToBackStack(null);
        trans.commit();
    }
}
