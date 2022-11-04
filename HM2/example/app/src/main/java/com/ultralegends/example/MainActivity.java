package com.ultralegends.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    Button incbtn, decbtn,resetbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textview);
        incbtn = findViewById(R.id.increment);
        decbtn = findViewById(R.id.decrement);
        resetbtn = findViewById(R.id.resetbtn);

        incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int data = Integer.parseInt(String.valueOf(textview.getText()));
                data=data+1;
                changetext(data);
                //textview.setText(data+"");
            }
        });

        decbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int data = Integer.parseInt(String.valueOf(textview.getText()));
                data=data-1;
                changetext(data);
                //textview.setText(data+"");
            }
        });
    }

    public void resetFunc(View view) {
        int data = Integer.parseInt(String.valueOf(textview.getText()));
        data=0;
        changetext(data);
        //textview.setText(data+"");
    }

    public void changetext(int data)
    {
        textview.setText(data+"");
    }

}