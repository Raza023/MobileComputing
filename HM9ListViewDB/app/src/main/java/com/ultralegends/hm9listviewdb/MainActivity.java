package com.ultralegends.hm9listviewdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    ListView listView;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        listView = findViewById(R.id.listView);

        list = new ArrayList<String>();
        HelperDB db = new HelperDB(this);
        list = db.getTasks();

        ArrayAdapter<String> adpt = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,list);

        listView.setAdapter(adpt);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if(!text.equals(""))
                {
                    editText.setText("");
                    db.insert(text);
                    list.add(text);
                    adpt.notifyDataSetChanged();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                db.delete(list.get(i));
                list.remove(i);
                adpt.notifyDataSetChanged();
            }
        });
    }
}