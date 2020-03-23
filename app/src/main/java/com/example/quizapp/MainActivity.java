package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {


    String word = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText result = (EditText) findViewById(R.id.result);
        result.setText("");

        catQuiz();
    }

    /**
    * This method is for CAT quiz
    * */
    public void catQuiz(){
        ImageView main_image = (ImageView) findViewById(R.id.image_main);
        main_image.setImageResource(R.drawable.cat);

        Button oneButton = (Button) findViewById(R.id.button1);
        oneButton.setText(R.string.thirtyfour);
        Button twoButton = (Button) findViewById(R.id.button2);
        twoButton.setText(R.string.two);
        Button threeButton = (Button) findViewById(R.id.button3);
        threeButton.setText(R.string.eight);
        Button fourButton = (Button) findViewById(R.id.button4);
        fourButton.setText(R.string.twenty);
        Button fiveButton = (Button) findViewById(R.id.button5);
        fiveButton.setText(R.string.seven);
        Button sixButton = (Button) findViewById(R.id.button6);
        sixButton.setText(R.string.fiftythree);
        Button sevenButton = (Button) findViewById(R.id.button7);
        sevenButton.setText(R.string.thirteen);
        TextView eightButton = (TextView) findViewById(R.id.button8);
        eightButton.setText(R.string.twelve);
    }

    public void one(View target) {
        EditText result = (EditText) findViewById(R.id.result);
        String temp = result.getText().toString();
        result.setText(temp + "" + R.string.twelve);
    }


    public void dogQuiz() {
        Button oneButton = (Button) findViewById(R.id.button1);
        oneButton.setText(R.string.thirtyfour);
        Button twoButton = (Button) findViewById(R.id.button2);
        twoButton.setText(R.string.two);
        Button threeButton = (Button) findViewById(R.id.button3);
        threeButton.setText(R.string.eight);
        Button fourButton = (Button) findViewById(R.id.button4);
        fourButton.setText(R.string.twenty);
        Button fiveButton = (Button) findViewById(R.id.button5);
        fiveButton.setText(R.string.seven);
        Button sixButton = (Button) findViewById(R.id.button6);
        sixButton.setText(R.string.fiftythree);
        Button sevenButton = (Button) findViewById(R.id.button7);
        sevenButton.setText(R.string.thirteen);
        TextView eightButton = (TextView) findViewById(R.id.button8);
        eightButton.setText(R.string.twelve);
    }

    public void clear(View view) {
        EditText result = (EditText) findViewById(R.id.result);
        result.setText("");
    }

    public void done(View view) {
        Toast.makeText(this, getText(R.string.great), Toast.LENGTH_LONG).show();
    }

}
