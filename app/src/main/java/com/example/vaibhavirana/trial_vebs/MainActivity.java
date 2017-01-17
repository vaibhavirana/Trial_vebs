package com.example.vaibhavirana.trial_vebs;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements RecyclerAdapter.ItemClick{
    ArrayList<Item> items;
    private RecyclerView recyclerView;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.sample_list);
        setupLayout();
    }


    public ArrayList<Item> getItems() {
        items = new ArrayList<>();
        items.add(new Item("HIGHLIGHTS", R.drawable.bg1));
        items.add(new Item("SCIENCE",R.drawable.bg2));
        items.add(new Item("GAMING", R.drawable.bg3));
        items.add(new Item("MOVIES", R.drawable.bg4));

        return items;
    }

    private void setupLayout() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(getItems());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v, int position) {

    }
}
