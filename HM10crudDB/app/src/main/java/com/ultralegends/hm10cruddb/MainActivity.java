package com.ultralegends.hm10cruddb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_name, et_roll_no;
    CheckBox cb_enroll;
    Button btn_save,btn_edit,btn_delete;
    ListView list_view;

    DBHandler db;
    ArrayList<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        et_roll_no = findViewById(R.id.et_roll_no);
        cb_enroll = findViewById(R.id.cb_enroll);
        btn_save = findViewById(R.id.btn_save);
        btn_edit = findViewById(R.id.btn_edit);
        btn_delete = findViewById(R.id.btn_delete);
        list_view = findViewById(R.id.list_view);

        db = new DBHandler(this);
        RefreshGrid();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String rollNo = et_roll_no.getText().toString();
                boolean isEnroll = cb_enroll.isChecked();
                if(name.equals("") && rollNo.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter valid data",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.insert(new Student(name,rollNo,isEnroll));
                    RefreshGrid();
                    Toast.makeText(MainActivity.this,"Student Record has been added",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String rollNo = et_roll_no.getText().toString();
                boolean isEnroll = cb_enroll.isChecked();
                if(name.equals("") && rollNo.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter valid data",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.update(new Student(name,rollNo,isEnroll));
                    RefreshGrid();
                    Toast.makeText(MainActivity.this,"Student Record has been updated",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNo = et_roll_no.getText().toString();
                if(rollNo.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter valid data",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.delete(rollNo);
                    RefreshGrid();
                    Toast.makeText(MainActivity.this,"Student Record has been deleted",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void RefreshGrid()
    {
        ArrayList<Student> list = new ArrayList<Student>();
        ArrayAdapter<Student> adpt = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1,list);
        list_view.setAdapter(adpt);
    }

}