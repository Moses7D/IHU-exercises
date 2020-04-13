package com.androidexercises.ihuexercises.set01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidexercises.ihuexercises.R;


public class FragmentsEmbededSecondFrag extends Fragment {

    public FragmentsEmbededSecondFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragments_embeded_second, container, false);
    }
}
