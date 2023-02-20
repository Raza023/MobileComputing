package com.example.hm15customizedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

//    ArrayList<MyCustomizedLayout> list;
    MyCustomizedLayout myCustomizedLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCustomizedLayout = new MyCustomizedLayout(MainActivity.this,new String[]{"1","2","3","4","5","6"} , new String[]{"1st","2nd","3rd","4th","5th","6th"});

        listView = findViewById(R.id.listView);

        listView.setAdapter(myCustomizedLayout);
    }
}