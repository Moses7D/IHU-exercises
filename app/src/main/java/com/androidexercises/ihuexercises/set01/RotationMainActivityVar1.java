package com.androidexercises.ihuexercises.set01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.androidexercises.ihuexercises.R;

import java.util.HashMap;

public class RotationMainActivityVar1 extends AppCompatActivity {

    private HashMap<String, Integer> articleBodyMap = new HashMap<>();
    private HashMap<String, Integer> articleTitleMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_main_var1);
        makeMaps();
        if(findViewById(R.id.fragCont) != null) {
            if(savedInstanceState != null) return;
            RotationFragmentVar1 frag = new RotationFragmentVar1();
            frag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragCont,frag,FragmentsSubsequentActivity.TAGS_MAIN_FRAGMENT);
        }
    }

    private void makeMaps(){
        articleTitleMap.put(((TextView)findViewById(R.id.option01)).getText().toString(),R.string.artTitlJava);
        articleTitleMap.put(((TextView)findViewById(R.id.option02)).getText().toString(),R.string.artTitlKotlin);
        articleTitleMap.put(((TextView)findViewById(R.id.option03)).getText().toString(),R.string.artTitlPython);

        articleBodyMap.put(((TextView)findViewById(R.id.option01)).getText().toString(),R.string.artBodJava);
        articleBodyMap.put(((TextView)findViewById(R.id.option02)).getText().toString(),R.string.artBodKotlin);
        articleBodyMap.put(((TextView)findViewById(R.id.option03)).getText().toString(),R.string.artBodPython);
    }

    public void selectArticle(View v){
        ((TextView)findViewById(R.id.artTitlCont)).setText(articleTitleMap.get(((TextView)v).getText().toString()));
        ((TextView)findViewById(R.id.artBodCont)).setText(articleBodyMap.get(((TextView)v).getText().toString()));
    }
}
