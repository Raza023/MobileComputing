package com.ultralegends.hm7alc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MA3","onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MA3","onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MA3","onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MA3","onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MA3","onDestroy called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MA3","onRestart called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d("MA3","onCreate called");
    }
}