package com.ultralegends.hm5intenturi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button sendBtn, browserBtn, dialBtn, mailBtn, mailBtn2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.sendBtn);
        browserBtn = findViewById(R.id.browserBtn);
        dialBtn = findViewById(R.id.dialBtn);
        mailBtn = findViewById(R.id.mailBtn);
        mailBtn2 = findViewById(R.id.mailBtn2);

        textView = findViewById(R.id.textView);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name",textView.getText().toString());
                intent.putExtra("StaticString","I live in Lahore.");
                intent.putExtra("age",22);

                startActivity(intent);
            }
        });

        browserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri =Uri.parse("tel:+923244614345");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        mailBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,"imhraza023@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT,"subject of email");
                if(intent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(intent);
                }
            }
        });

        mailBtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:hr770735@gmail.com"));
//                intent.setType("*/*");
//                intent.setDataAndType(Uri.parse("mailto:hr770735@gmail.com"),"*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,"imhraza023@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT,"subject of email");
                if(intent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(intent);
                }
            }
        });
    }
}