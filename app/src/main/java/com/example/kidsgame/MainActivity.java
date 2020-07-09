package com.example.kidsgame;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kidsgame.models.ScreenModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> myList = new ArrayList<>();

    private String category;
    private String answer;
    private String animalName;
    private String transportName;

    private String image;
    private String[] buttonsSyllables;

    // Getters
    public String getCategory() {
        return category;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getTransportName() {
        return transportName;
    }

    public String getImage() {
        return image;
    }

    public String getAnswer() {
        return answer;
    }

    public String[] getButtonsSyllables() {
        return buttonsSyllables;
    }

    // Setters
    public void setCategory(String category) {
        this.category = category;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public void setButtonsSyllables(String[] buttonsSyllables) {

        this.buttonsSyllables = buttonsSyllables;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        result.setText("");
        new JSONTask().execute("https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/app/src/main/assets/screens.json");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; This adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button,
        // so long as you specify a parent actually in AndroidManifest.xml
        int id = item.getItemId();

        // no inspection SimplifiableIfStatement
        if (id == R.id.menu_about) {
            // TODO: web link open: "https://github.com/mobilotest/Kids_Game_Final_Project#kids-game---final-project-for-ucsc-extension"
            return true;
        }

        if (id == R.id.menu_help) {
            // TODO: web link open: "https://github.com/mobilotest/Kids_Game_Final_Project#kids-game---final-project-for-ucsc-extension"
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}