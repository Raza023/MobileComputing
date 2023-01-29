package com.ultralegends.hm7alc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button btnAct3;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MA2","onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MA2","onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MA2","onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MA2","onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MA2","onDestroy called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MA2","onRestart called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("MA2","onCreate called");

        btnAct3 = findViewById(R.id.btnActOn2);

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}