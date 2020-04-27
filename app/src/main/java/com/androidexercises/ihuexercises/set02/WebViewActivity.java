package com.androidexercises.ihuexercises.set02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.androidexercises.ihuexercises.R;

public class WebViewActivity extends AppCompatActivity implements WebSearchFragment.OnWebSearchListener{

    public static final String URL = "com.androidexercises.ihuexercises.set02.WEB_VIEW_URL";
    private ViewPager webBrowserPager;
    private EmbeddedBrowserPagerAdapter webBrowserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webBrowserPager = findViewById(R.id.pagerEmbeddedWeb);
        webBrowserAdapter = new EmbeddedBrowserPagerAdapter(getSupportFragmentManager(),EmbeddedBrowserPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        webBrowserPager.setAdapter(webBrowserAdapter);
    }

    public void onSearch(String url){

    }

}
