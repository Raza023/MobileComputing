package com.ultralegends.hm5intenturi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView receivingTextView,receivingString,receivingNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        receivingTextView = findViewById(R.id.receivingTextView);
        receivingString = findViewById(R.id.receivingString);
        receivingNumber = findViewById(R.id.receivingNumber);

        Intent intent = getIntent();
        receivingTextView.setText(intent.getStringExtra("name"));
        receivingString.setText(intent.getStringExtra("StaticString"));
        receivingNumber.setText(Integer.toString(intent.getIntExtra("age",0)));
    }
}