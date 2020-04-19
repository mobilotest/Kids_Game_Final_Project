package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText result = (EditText) findViewById(R.id.result);
        result.setText("");

//        list = (ListView) findViewById(R.string.);
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(MainActivity.this,
//                        android.R.layout.simple_list_item_1,
//                        android.R.id.text1);
//
//        for (String temp_result : result)
//        {
//            adapter.add(temp_result);
//        }

// Assign adapter to ListView
//        list.setAdapter(adapter);
//
//        for(int i=0; i.animals)
//        Cat(R.drawable.cat, R.string.cat, R.string.thirtyfour, R.string.thirtyfive, R.string.eight, R.string.twenty, R.string.seven, R.string.fiftythree, R.string.thirteen, R.string.twelve);
        Ant(R.drawable.ant, R.string.ant, R.string.thirtyfour, R.string.three, R.string.eight, R.string.twentynine, R.string.thirtyone, R.string.fiftythree, R.string.fourteen, R.string.twelve);
//        Cow(R.drawable.ant, R.string.cow, R.string.fifteen, R.string.four, R.string.five, R.string.twentynine, R.string.thirtyone, R.string.seven, R.string.twenty, R.string.six);

        // HOW TO SWITCH

    }


    /**
     * This method for cat only so far
     **/
    public void Cat(int img_resource, int str_animal, int btn1_resource_text, int btn2_resource_text, int btn3_resource_text, int btn4_resource_text, int btn5_resource_text, int btn6_resource_text, int btn7_resource_text, int btn8_resource_text) {

        ImageView main_image = (ImageView) findViewById(R.id.image_main);
        EditText result = (EditText) findViewById(R.id.result);

        Button oneButton = (Button) findViewById(R.id.button1);
        Button twoButton = (Button) findViewById(R.id.button2);
        Button threeButton = (Button) findViewById(R.id.button3);
        Button fourButton = (Button) findViewById(R.id.button4);
        Button fiveButton = (Button) findViewById(R.id.button5);
        Button sixButton = (Button) findViewById(R.id.button6);
        Button sevenButton = (Button) findViewById(R.id.button7);
        Button eightButton = (Button) findViewById(R.id.button8);

        main_image.setImageResource(img_resource);
        result.getText().toString().equals(str_animal);

        oneButton.setText(btn1_resource_text);
        twoButton.setText(btn2_resource_text);
        threeButton.setText(btn3_resource_text);
        fourButton.setText(btn4_resource_text);
        fiveButton.setText(btn5_resource_text);
        sixButton.setText(btn6_resource_text);
        sevenButton.setText(btn7_resource_text);
        eightButton.setText(btn8_resource_text);
    }

    /**
     * This method is just for ant
     **/
    public void Ant(int img_resource, int str_animal, int btn1_resource_text, int btn2_resource_text, int btn3_resource_text, int btn4_resource_text, int btn5_resource_text, int btn6_resource_text, int btn7_resource_text, int btn8_resource_text) {

        ImageView main_image = (ImageView) findViewById(R.id.image_main);
        EditText result = (EditText) findViewById(R.id.result);

        Button oneButton = (Button) findViewById(R.id.button1);
        Button twoButton = (Button) findViewById(R.id.button2);
        Button threeButton = (Button) findViewById(R.id.button3);
        Button fourButton = (Button) findViewById(R.id.button4);
        Button fiveButton = (Button) findViewById(R.id.button5);
        Button sixButton = (Button) findViewById(R.id.button6);
        Button sevenButton = (Button) findViewById(R.id.button7);
        Button eightButton = (Button) findViewById(R.id.button8);

        main_image.setImageResource(img_resource);
        result.getText().toString().equals(str_animal);

        oneButton.setText(btn1_resource_text);
        twoButton.setText(btn2_resource_text);
        threeButton.setText(btn3_resource_text);
        fourButton.setText(btn4_resource_text);
        fiveButton.setText(btn5_resource_text);
        sixButton.setText(btn6_resource_text);
        sevenButton.setText(btn7_resource_text);
        eightButton.setText(btn8_resource_text);
    }

    public void Cow(int img_resource, int str_animal, int btn1_resource_text, int btn2_resource_text, int btn3_resource_text, int btn4_resource_text, int btn5_resource_text, int btn6_resource_text, int btn7_resource_text, int btn8_resource_text) {

        ImageView main_image = (ImageView) findViewById(R.id.image_main);
        EditText result = (EditText) findViewById(R.id.result);

        Button oneButton = (Button) findViewById(R.id.button1);
        Button twoButton = (Button) findViewById(R.id.button2);
        Button threeButton = (Button) findViewById(R.id.button3);
        Button fourButton = (Button) findViewById(R.id.button4);
        Button fiveButton = (Button) findViewById(R.id.button5);
        Button sixButton = (Button) findViewById(R.id.button6);
        Button sevenButton = (Button) findViewById(R.id.button7);
        Button eightButton = (Button) findViewById(R.id.button8);

        main_image.setImageResource(img_resource);
        result.getText().toString().equals(str_animal);

        oneButton.setText(btn1_resource_text);
        twoButton.setText(btn2_resource_text);
        threeButton.setText(btn3_resource_text);
        fourButton.setText(btn4_resource_text);
        fiveButton.setText(btn5_resource_text);
        sixButton.setText(btn6_resource_text);
        sevenButton.setText(btn7_resource_text);
        eightButton.setText(btn8_resource_text);
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
        EditText edit_text = (EditText) findViewById(R.id.result);

        if (edit_text.getText().toString().equalsIgnoreCase("ANT")) { // HOW TO COMPARE?
            toastMessage(R.string.great);
        } else {
            toastMessage(R.string.fail);
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

    public void toastMessage(int resource) {
        Toast toast = Toast.makeText(getApplicationContext(), getText(resource), Toast.LENGTH_SHORT);
        TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
        toastMessage.setTextColor(Color.RED);
        toastMessage.setTextSize(45);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}


