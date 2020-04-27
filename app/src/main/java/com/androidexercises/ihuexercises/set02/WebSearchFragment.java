package com.androidexercises.ihuexercises.set02;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.androidexercises.ihuexercises.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebSearchFragment extends Fragment {
    EditText searchText;
    Button searchB;
    OnWebSearchListener attachedActivity;

    public WebSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_web_search, container, false);
        searchText = v.findViewById(R.id.urlSearchView);
        searchB = v.findViewById(R.id.searchB);
        searchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(v);
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            attachedActivity = (OnWebSearchListener) context;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void search(View v){
        attachedActivity.onSearch(searchText.getText().toString());
    }

    public interface OnWebSearchListener {
        public void onSearch(String url);
    }
}
