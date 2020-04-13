package com.androidexercises.ihuexercises.set01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.androidexercises.ihuexercises.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentsFragToActMainFragment extends Fragment {
    private OnMessageSendListener attachedActivity;
    private EditText messageCont;

    public FragmentsFragToActMainFragment() {
        // Required empty public constructor
    }

    public interface OnMessageSendListener {
        public void onMessageSend(String message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragments_frag_to_act_main, container, false);
        Button but  = view.findViewById(R.id.sendBut);
        messageCont = view.findViewById(R.id.messageCont);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(v);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            attachedActivity = (OnMessageSendListener) activity;
        } catch(ClassCastException ex) {
            ex.printStackTrace();
        }

    }

    public void send(View v) {
        attachedActivity.onMessageSend(messageCont.getText().toString());
    }
}
