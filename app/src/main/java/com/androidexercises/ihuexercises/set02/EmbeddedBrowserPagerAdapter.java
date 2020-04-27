package com.androidexercises.ihuexercises.set02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class EmbeddedBrowserPagerAdapter extends FragmentPagerAdapter {
    private Bundle urlBundle;
    private WebSearchFragment searchF;
    private WebViewFragment browserF;

    public EmbeddedBrowserPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        urlBundle = new Bundle();
        urlBundle.putString(WebViewActivity.URL, "www.google.com");
        searchF = new WebSearchFragment();
        browserF = new WebViewFragment();
    }

    public boolean setBundle(Bundle extra){
        if(extra == null){
            return false;
        }
        String url = extra.getString(WebViewActivity.URL);
        if(url == null) {
            extra.putString(WebViewActivity.URL, "www.google.com");
            urlBundle = extra;
            return true;
        }
        if(url.isEmpty()) {
            urlBundle = extra;
            return true;
        }
        urlBundle = new Bundle();
        urlBundle.putString(WebViewActivity.URL, "www.google.com");
        return false;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return searchF;
        } else {
            browserF.setArguments(urlBundle);
            return browserF;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
