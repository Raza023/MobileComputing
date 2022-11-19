package com.ultralegends.hm42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String []skyLetters = {"l","k","f","t","d","h","b"};
    String []grassLetters = {"c","o","i","e","z","v","w","x","s","a","u","r","n","m"};
    String []rootLetters = {"p","q","j","y","g"};

    TextView randomChar, resultText, skyResult, grassResult, rootResult;
    Button skybtn, grassbtn, rootbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomChar = findViewById(R.id.randomChar);
        resultText = findViewById(R.id.resultText);
        skyResult = findViewById(R.id.skyResult);
        grassResult = findViewById(R.id.grassResult);
        rootResult = findViewById(R.id.rootResult);

        skybtn = findViewById(R.id.skybtn);
        grassbtn = findViewById(R.id.grassbtn);
        rootbtn = findViewById(R.id.rootbtn);

        skybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        grassbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        rootbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        
    }
}