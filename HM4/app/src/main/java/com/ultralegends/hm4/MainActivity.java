package com.ultralegends.hm4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView q1, q2, showResult;
    RadioButton q1o1,q1o2,q1o3,q1o4,q2o1,q2o2,q2o3,q2o4;


    String [] questions = {"Who is the king of Jungle?","What is the SI unit of distance?"};

    int noOfQuestions = questions.length;


    String [] options1 = {"Elephant","Lion","Tiger","Deer"};
    String [] options2 = {"meter","Kelvin","liter","Joule"};

    int noOfOptions = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);

        shuffleArray(questions);
        shuffleArray(options1);
        shuffleArray(options2);

    }



    public void shuffleArray(Object[] array)
    {
        int arrLength = array.length;
        for (int i=0;i<arrLength; i++)
        {
            int s = i+ (int)(Math.random()*(arrLength-i));
            Object temp =array[s];
            array[s] = array[i];
            array[i] = temp;
        }
    }
}


