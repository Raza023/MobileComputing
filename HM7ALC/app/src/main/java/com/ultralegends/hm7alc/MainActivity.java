package com.ultralegends.hm7alc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    Button countBtn, btnAct2, btnAct3;
    TextView counterView;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MA","onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MA","onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MA","onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MA","onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MA","onDestroy called");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {    //rotate wala masla has been solved
        super.onSaveInstanceState(outState);
        outState.putInt("counterKey",counter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null)
        {
            counter = savedInstanceState.getInt("counterKey");
            counterView.setText(Integer.toString(counter));
        }

        countBtn = findViewById(R.id.countBtn);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        counterView = findViewById(R.id.counterView);

        Log.d("MA","onCreate called");

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                counterView.setText(Integer.toString(counter));
            }
        });

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }

}