package com.ultralegends.hm42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String []skyLetters = {"l","k","f","t","d","h","b"};
    String []grassLetters = {"c","o","i","e","z","v","w","x","s","a","u","r","n","m"};
    String []rootLetters = {"p","q","j","y","g"};

    String []letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    TextView randomChar, resultText, skyResult, grassResult, rootResult;
    Button skybtn, grassbtn, rootbtn;

    int skyCorrectCounter = 0;
    int skyWrongCounter = 0;
    int grassCorrectCounter = 0;
    int grassWrongCounter = 0;
    int rootCorrectCounter = 0;
    int rootWrongCounter = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomChar = findViewById(R.id.randomChar);
        resultText = findViewById(R.id.resultText);
        skyResult = findViewById(R.id.skyResult);
        grassResult = findViewById(R.id.grassResult);
        rootResult = findViewById(R.id.rootResult);

        skybtn = findViewById(R.id.skybtn);
        grassbtn = findViewById(R.id.grassbtn);
        rootbtn = findViewById(R.id.rootbtn);

        changeChar();

        skybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String randChar = randomChar.getText().toString();
                if(randChar.equals("l") || randChar.equals("k") || randChar.equals("f") || randChar.equals("t") || randChar.equals("d") || randChar.equals("h") || randChar.equals("b"))
                {
                    skyCorrectCounter++;
                    resultText.setText("Spot on!");
                    skyResult.setText("Sky Result:\nCorrect: "+skyCorrectCounter+"\nWrong: "+skyWrongCounter);
                }
                else
                {
                    skyWrongCounter++;
                    resultText.setText("Whoopsy!");
                    skyResult.setText("Sky Result:\nCorrect: "+skyCorrectCounter+"\nWrong: "+skyWrongCounter);
                }
                changeChar();
            }
        });

        grassbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String randChar = randomChar.getText().toString();
                if(randChar.equals("c") || randChar.equals("o") || randChar.equals("i") || randChar.equals("e") || randChar.equals("z") || randChar.equals("v") || randChar.equals("x") || randChar.equals("s") || randChar.equals("a") || randChar.equals("u") || randChar.equals("w") || randChar.equals("r") || randChar.equals("n") || randChar.equals("m"))
                {
                    grassCorrectCounter++;
                    resultText.setText("Spot on!");
                    grassResult.setText("Grass Result:\nCorrect: "+grassCorrectCounter+"\nWrong: "+grassWrongCounter);
                }
                else
                {
                    grassWrongCounter++;
                    resultText.setText("Whoopsy!");
                    grassResult.setText("Grass Result:\nCorrect: "+grassCorrectCounter+"\nWrong: "+grassWrongCounter);
                }
                changeChar();
            }
        });

        rootbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String randChar = randomChar.getText().toString();
                if(randChar.equals("p") || randChar.equals("q") || randChar.equals("j") || randChar.equals("y") || randChar.equals("g"))
                {
                    rootCorrectCounter++;
                    resultText.setText("Spot on!");
                    rootResult.setText("Root Result:\nCorrect: "+rootCorrectCounter+"\nWrong: "+rootWrongCounter);
                }
                else
                {
                    rootWrongCounter++;
                    resultText.setText("Whoopsy!");
                    rootResult.setText("Root Result:\nCorrect: "+rootCorrectCounter+"\nWrong: "+rootWrongCounter);
                }
                changeChar();
            }
        });
    }

    public void changeChar()
    {
        shuffleArray(letters);
        randomChar.setText(letters[0]);
    }

    public void shuffleArray(Object []array)
    {
        int arrLength = array.length;
        for(int i=0;i<arrLength;i++)
        {
            int s = i+(int)(Math.random()*(arrLength-i));
            Object temp =array[s];
            array[s] =array[i];
            array[i] = temp;
        }
    }
}