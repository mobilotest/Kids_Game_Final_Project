package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    Resources res = getResources();
    String[] animals = res.getStringArray(R.array.animals);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText result = (EditText) findViewById(R.id.result);
        result.setText("");

        quiz();
    }


    /**
     * This method is for CAT quiz
     **/
    public void quiz() {
        ImageView main_image = (ImageView) findViewById(R.id.image_main);
        Button oneButton = (Button) findViewById(R.id.button1);
        Button twoButton = (Button) findViewById(R.id.button2);
        Button threeButton = (Button) findViewById(R.id.button3);
        Button fourButton = (Button) findViewById(R.id.button4);
        Button fiveButton = (Button) findViewById(R.id.button5);
        Button sixButton = (Button) findViewById(R.id.button6);
        Button sevenButton = (Button) findViewById(R.id.button7);
        TextView eightButton = (TextView) findViewById(R.id.button8);

        for (int i = 0; i < animals.length; i++) {
            switch (i) {
                case 0:
                    main_image.setImageResource(R.drawable.cat);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 1:
                    main_image.setImageResource(R.drawable.ant);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.twentynine);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twentyeight);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirtyone);
                    eightButton.setText(R.string.fortythree);
                    break;
                case 2:
                    main_image.setImageResource(R.drawable.butterfly);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 3:
                    main_image.setImageResource(R.drawable.cow);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 4:
                    main_image.setImageResource(R.drawable.crocodile);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 5:
                    main_image.setImageResource(R.drawable.dog);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 6:
                    main_image.setImageResource(R.drawable.grasshopper);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 7:
                    main_image.setImageResource(R.drawable.horse);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 8:
                    main_image.setImageResource(R.drawable.fish);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 9:
                    main_image.setImageResource(R.drawable.owl);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 10:
                    main_image.setImageResource(R.drawable.peacock);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 11:
                    main_image.setImageResource(R.drawable.rabbit);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 12:
                    main_image.setImageResource(R.drawable.snake);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                case 13:
                    main_image.setImageResource(R.drawable.zebra);
                    oneButton.setText(R.string.thirtyfour);
                    twoButton.setText(R.string.two);
                    threeButton.setText(R.string.eight);
                    fourButton.setText(R.string.twenty);
                    fiveButton.setText(R.string.seven);
                    sixButton.setText(R.string.fiftythree);
                    sevenButton.setText(R.string.thirteen);
                    eightButton.setText(R.string.twelve);
                    break;
                default:
                    // code block
            }
        }
    }


    /**
     * This method put part of the word to the edit field from button 1
     **/
    public void one(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        EditText result = (EditText) findViewById(R.id.result);
        Editable temp = result.getText();
        result.setText(temp + "" + buttonText);
    }


    /**
     * This method put part of the word to the edit field from button 2
     **/
    public void two(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        EditText result = (EditText) findViewById(R.id.result);
        Editable temp = result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 3
     **/
    public void three(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        EditText result = (EditText) findViewById(R.id.result);
        Editable temp = result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 4
     **/
    public void four(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        EditText result = (EditText) findViewById(R.id.result);
        Editable temp = result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 5
     **/
    public void five(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        EditText result = (EditText) findViewById(R.id.result);
        Editable temp = result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 6
     **/
    public void six(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        EditText result = (EditText) findViewById(R.id.result);
        Editable temp = result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 7
     **/
    public void seven(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        EditText result = (EditText) findViewById(R.id.result);
        Editable temp = result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 8
     **/
    public void eight(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        EditText result = (EditText) findViewById(R.id.result);
        Editable temp = result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method will switch to the new question if answer is correct
     **/
    public void next(View v) {

    }

    /**
     * This method should clean the EditText box with the answer
     **/
    public void clear(View view) {
        EditText result = (EditText) findViewById(R.id.result);
        result.setText("");
    }

    /**
     * This method will check if answer is correct or not and throw a toast message accordingly
     **/
    public void done(View view) {
        EditText result = (EditText) findViewById(R.id.result);
        ImageView img = (ImageView) findViewById(R.id.image_main);
        String c = img.getContext().toString();

        if (result.getText().toString().equals("CAT")) {
            toastMessage(R.string.great);
        } else {
            toastMessage(R.string.fail);
        }
    }

    public void toastMessage(int resource) {
        Toast toast = Toast.makeText(getApplicationContext(), getText(resource), Toast.LENGTH_SHORT);
        TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
        toastMessage.setTextColor(Color.RED);
        toastMessage.setTextSize(45);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}


