package com.ultralegends.hm4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView q1, q2, showResult;
    RadioGroup q1Group, q2Group;
    RadioButton sample,q1o1,q1o2,q1o3,q1o4,q2o1,q2o2,q2o3,q2o4;
    Button resultbtn;
    int counter=0;

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
        q1Group = findViewById(R.id.q1group);
        q1o1 = findViewById(R.id.q1o1);
        q1o2 = findViewById(R.id.q1o2);
        q1o3 = findViewById(R.id.q1o3);
        q1o4 = findViewById(R.id.q1o4);

        q2 = findViewById(R.id.q2);
        q2Group = findViewById(R.id.q2group);
        q2o1 = findViewById(R.id.q2o1);
        q2o2 = findViewById(R.id.q2o2);
        q2o3 = findViewById(R.id.q2o3);
        q2o4 = findViewById(R.id.q2o4);

        showResult = findViewById(R.id.showResult);
        resultbtn = findViewById(R.id.resultbtn);

        shuffleArray(questions);
        shuffleArray(options1);
        shuffleArray(options2);

        q1.setText(questions[0]);
        setOptionsOfThisQustion(q1,q1o1,q1o2,q1o3,q1o4);
        q2.setText(questions[1]);
        setOptionsOfThisQustion(q2,q2o1,q2o2,q2o3,q2o4);

        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAnswer(q1, q1Group);
                CheckAnswer(q2, q2Group);
                if(counter!=0)
                {
                    showResult.setText("Your result: "+counter+"/2");
                }
            }
        });
    }

    public void setOptionsOfThisQustion(TextView question, RadioButton o1,RadioButton o2,RadioButton o3,RadioButton o4)
    {
        if(question.getText().toString().equals("Who is the king of Jungle?"))
        {
            o1.setText(options1[0]);
            o2.setText(options1[1]);
            o3.setText(options1[2]);
            o4.setText(options1[3]);
        }
        else if(question.getText().toString().equals("What is the SI unit of distance?"))
        {
            o1.setText(options2[0]);
            o2.setText(options2[1]);
            o3.setText(options2[2]);
            o4.setText(options2[3]);
        }
    }

    public void CheckAnswer(TextView question, RadioGroup qGroup)
    {
        int checkedButtenId = qGroup.getCheckedRadioButtonId();
        sample = findViewById(checkedButtenId);
        if(question.getText().toString().equals("Who is the king of Jungle?"))
        {
            if(sample.getText().toString().equals("Lion"))
            {
                counter++;
            }
        }
        else if(question.getText().toString().equals("What is the SI unit of distance?"))
        {
            if(sample.getText().toString().equals("meter"))
            {
                counter++;
            }
        }
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


