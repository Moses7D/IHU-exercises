package com.androidexercises.ihuexercises.set01;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.androidexercises.ihuexercises.R;


public class FragmentsSubsequentActivity extends FragmentActivity {
    public static final String TAGS_MAIN_FRAGMENT = "com.androidexercises.teitheexercises.set01.SUB_FRAG_MAIN";
    public static final String TAGS_FIRST_FRAGMENT = "com.androidexercises.teitheexercises.set01.SUB_FRAG_FIRST";
    public static final String TAGS_SECOND_FRAGMENT = "com.androidexercises.teitheexercises.set01.SUB_FRAG_SECOND";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_subsequent);
        if(findViewById(R.id.fragCont) != null) {
            if(savedInstanceState != null) return;
            FragmentsSubsequentMainFragment mainFragment = new FragmentsSubsequentMainFragment();
            mainFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragCont,mainFragment,FragmentsSubsequentActivity.TAGS_MAIN_FRAGMENT);
        }
    }

    public void openNext(View v) {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.fragCont);
        if(frag instanceof FragmentsSubsequentMainFragment) {
            FragmentsSubsequentFirstFragment firstFragment = new FragmentsSubsequentFirstFragment();
            FragmentTransaction transaction = frag.getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragCont,firstFragment, FragmentsSubsequentActivity.TAGS_FIRST_FRAGMENT);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            FragmentsSubsequentSecondFragment secondFragment = new FragmentsSubsequentSecondFragment();
            FragmentTransaction transaction = frag.getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragCont,secondFragment, FragmentsSubsequentActivity.TAGS_SECOND_FRAGMENT);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
