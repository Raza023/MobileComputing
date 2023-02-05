package com.ultralegends.hm12recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friendArrayList = new ArrayList<Friend>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Friend f0 = new Friend(1,R.drawable.d,"Asad", 1980, "Gilgit");
        Friend f1 = new Friend(2,R.drawable.c,"Zubair", 1981, "Lahore");
        Friend f2 = new Friend(3,R.drawable.b,"Musa", 1980, "Quetta");
        Friend f3 = new Friend(4,R.drawable.a,"Nadeem",1987,"Peshawar");
        Friend f4 = new Friend(5,R.drawable.c,"Shahid", 1980, "Karachi");
        Friend f5 = new Friend(6,R.drawable.a,"Zia",1987,"Faisalabad ");
        Friend f6 = new Friend(7,R.drawable.d,"Badar", 1980, "Rawalpindi");
        Friend f7 = new Friend(8,R.drawable.b,"Hashim",1997,"Karachi");
        Friend f8 = new Friend(9,R.drawable.c,"Salman",1980,"Quetta");
        Friend f9 = new Friend(10,R.drawable.d,"Rizwan",1982,"Kasur");
        Friend f10 = new Friend(11,R.drawable.a,"Junaid",1977,"Islamabad");
        Friend f11 = new Friend(12,R.drawable.b,"Waseem",1967,"Rawalpindi");
        friendArrayList.addAll(Arrays.asList(new Friend[]{f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11}));

        recyclerView = findViewById(R.id.recylerViewStudent);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(MainActivity.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false); //(context,orientation,reverseLayout);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(friendArrayList);
        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();

    }
}