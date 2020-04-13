package com.androidexercises.ihuexercises.set01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidexercises.ihuexercises.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentsFragToFragSecondFragment extends Fragment {

    public FragmentsFragToFragSecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragments_frag_to_frag_second, container, false);
        TextView outputCont = view.findViewById(R.id.outputCont);
        Bundle b = getArguments();
        outputCont.setText(b.getString(FragmentsFragToFragActivity.EXTRA_MESSAGE));
        return view;
    }
}
