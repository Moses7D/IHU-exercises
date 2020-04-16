package com.androidexercises.ihuexercises.set02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.androidexercises.ihuexercises.R;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class RecyclerListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> data;
    private RecyclerListAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerList);
        recyclerView.setLayoutManager(layoutManager);
        data = Arrays.asList(getResources().getStringArray(R.array.cocoNames));
        adapter = new RecyclerListAdapter(data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
