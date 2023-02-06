package com.ultralegends.hm13sabaqsabqimanzil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<Students> studentArrayList = new ArrayList<Students>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        studentArrayList = db.

        recyclerView = findViewById(R.id.recylerViewStudent);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(MainActivity2.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false); //(context,orientation,reverseLayout);
        recyclerView.setLayoutManager(layoutManager);

//        adapter = new myRecyclerViewAdapter(studentArrayList);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }
}