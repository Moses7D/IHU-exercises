package com.androidexercises.ihuexercises.set02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.androidexercises.ihuexercises.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {
    WebView embBrowser;

    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_web_view, container, false);
        embBrowser = v.findViewById(R.id.embededBrowser);
        return v;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        embBrowser.loadUrl(outState.getString(WebViewActivity.URL));
    }
}
