package com.ultralegends.hm13sabaqsabqimanzil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText stdName, stdrollNo, stdSabaq, stdSabqi, stdManzil;
    ListView stdListView;
    Button showStd, addBtn;

    HelperDB db;
    ArrayList<Students> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stdName = findViewById(R.id.stdName);
        stdrollNo = findViewById(R.id.stdrollNo);
        stdSabaq = findViewById(R.id.stdSabaq);
        stdSabqi = findViewById(R.id.stdSabqi);
        stdManzil = findViewById(R.id.stdManzil);
        stdListView = findViewById(R.id.stdListView);
        showStd = findViewById(R.id.showStd);
        addBtn = findViewById(R.id.addBtn);

        list = new ArrayList<Students>();

        db = new HelperDB(this);
        RefreshGrid();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(stdName.getText().toString().equals("") || stdrollNo.getText().toString().equals("") || stdSabaq.getText().toString().equals("") || stdSabqi.getText().toString().equals("") || stdManzil.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter valid data of Student.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int id = 0;
                    String name = stdName.getText().toString();
                    String rollNo = stdrollNo.getText().toString();
                    int sabaq = Integer.parseInt(stdSabaq.getText().toString());
                    int sabqi = Integer.parseInt(stdSabqi.getText().toString());
                    int manzil = Integer.parseInt(stdManzil.getText().toString());

                    list.add(new Students(id,name,rollNo,sabaq,sabqi,manzil));
                    db.insert(new Students(id,name,rollNo,sabaq,sabqi,manzil));
                    RefreshGrid();
                    Toast.makeText(MainActivity.this,"Student Record has been added.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        showStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    public void RefreshGrid()
    {
        ArrayList<Students> list = db.getStudents();
        ArrayAdapter<Students> adpt = new ArrayAdapter<Students>(MainActivity.this, android.R.layout.simple_list_item_1,list);
        stdListView.setAdapter(adpt);
    }
}