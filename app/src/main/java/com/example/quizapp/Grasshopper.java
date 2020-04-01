package com.example.quizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Grasshopper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText result = (EditText) findViewById(R.id.result);
        result.setText("");
    }

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

    /**
     * This method is general for quiz
     **/
    public Grasshopper(int img_resource, int str_animal, int btn1_resource_text, int btn2_resource_text, int btn3_resource_text, int btn4_resource_text, int btn5_resource_text, int btn6_resource_text, int btn7_resource_text, int btn8_resource_text) {

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
}
