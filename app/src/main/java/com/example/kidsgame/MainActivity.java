package com.example.kidsgame;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String url = "https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/app/src/main/assets/screens.json";
    ProgressDialog dialog;

    String jsonString = "{\n" +
            "  \"screens\": {\n" +
            "    \"1\": {\n" +
            "      \"category\": \"animals\",\n" +
            "      \"image\": \"https://raw.githubusercontent.com/mobilotest/Kids_Game_Final_Project/master/app/src/main/res/drawable/ant.png\",\n" +
            "      \"answer\": \"ANT\",\n" +
            "      \"button_1\": \"DA\",\n" +
            "      \"button_2\": \"RE\",\n" +
            "      \"button_3\": \"A\",\n" +
            "      \"button_4\": \"NO\",\n" +
            "      \"button_5\": \"T\",\n" +
            "      \"button_6\": \"BR\",\n" +
            "      \"button_7\": \"N\",\n" +
            "      \"button_8\": \"U\"\n" +
            "    },\n" +
            "    \"2\": {\n" +
            "      \"category\": \"animals\",\n" +
            "      \"image\": \"https://raw.githubusercontent.com/mobilotest/Kids_Game_Final_Project/master/app/src/main/res/drawable/cow.png\",\n" +
            "      \"answer\": \"COW\",\n" +
            "      \"button_1\": \"DA\",\n" +
            "      \"button_2\": \"C\",\n" +
            "      \"button_3\": \"A\",\n" +
            "      \"button_4\": \"NY\",\n" +
            "      \"button_5\": \"T\",\n" +
            "      \"button_6\": \"O\",\n" +
            "      \"button_7\": \"SE\",\n" +
            "      \"button_8\": \"V\"\n" +
            "    },\n" +
            "    \"3\": {\n" +
            "      \"category\": \"animals\",\n" +
            "      \"image\": \"https://raw.githubusercontent.com/mobilotest/Kids_Game_Final_Project/master/app/src/main/res/drawable/butterfly.png\",\n" +
            "      \"answer\": \"BUTTERFLY\",\n" +
            "      \"button_1\": \"ER\",\n" +
            "      \"button_2\": \"CA\",\n" +
            "      \"button_3\": \"BA\",\n" +
            "      \"button_4\": \"ME\",\n" +
            "      \"button_5\": \"TT\",\n" +
            "      \"button_6\": \"LY\",\n" +
            "      \"button_7\": \"N\",\n" +
            "      \"button_8\": \"F\"\n" +
            "    },\n" +
            "    \"4\": {\n" +
            "      \"category\": \"animals\",\n" +
            "      \"image\": \"https://raw.githubusercontent.com/mobilotest/Kids_Game_Final_Project/master/app/src/main/res/drawable/cat.png\",\n" +
            "      \"answer\": \"CAT\",\n" +
            "      \"button_1\": \"ER\",\n" +
            "      \"button_2\": \"A\",\n" +
            "      \"button_3\": \"BA\",\n" +
            "      \"button_4\": \"ME\",\n" +
            "      \"button_5\": \"C\",\n" +
            "      \"button_6\": \"T\",\n" +
            "      \"button_7\": \"N\",\n" +
            "      \"button_8\": \"F\"\n" +
            "    },\n" +
            "    \"5\": {\n" +
            "      \"category\": \"transport\",\n" +
            "      \"image\": \"http://pngimg.com/uploads/tractor/tractor_PNG16116.png\",\n" +
            "      \"answer\": \"TRACTOR\",\n" +
            "      \"button_1\": \"R\",\n" +
            "      \"button_2\": \"RE\",\n" +
            "      \"button_3\": \"A\",\n" +
            "      \"button_4\": \"TRA\",\n" +
            "      \"button_5\": \"C\",\n" +
            "      \"button_6\": \"BR\",\n" +
            "      \"button_7\": \"N\",\n" +
            "      \"button_8\": \"TO\"\n" +
            "    },\n" +
            "    \"6\": {\n" +
            "      \"category\": \"transport\",\n" +
            "      \"image\": \"http://pngimg.com/uploads/plane/plane_PNG5238.png\",\n" +
            "      \"answer\": \"PLANE\",\n" +
            "      \"button_1\": \"X\",\n" +
            "      \"button_2\": \"RE\",\n" +
            "      \"button_3\": \"P\",\n" +
            "      \"button_4\": \"LA\",\n" +
            "      \"button_5\": \"C\",\n" +
            "      \"button_6\": \"BR\",\n" +
            "      \"button_7\": \"NE\",\n" +
            "      \"button_8\": \"QU\"\n" +
            "    }\n" +
            "  }\n" +
            "}";

    String answer = "";

    private String category;
    private TextView result;
    private ImageView image;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        image = (ImageView) findViewById(R.id.image_main);
        btn_1 = (Button) findViewById(R.id.button1);
        btn_2 = (Button) findViewById(R.id.button2);
        btn_3 = (Button) findViewById(R.id.button3);
        btn_4 = (Button) findViewById(R.id.button4);
        btn_5 = (Button) findViewById(R.id.button5);
        btn_6 = (Button) findViewById(R.id.button6);
        btn_7 = (Button) findViewById(R.id.button7);
        btn_8 = (Button) findViewById(R.id.button8);

        try {
            JSONObject jObject = new JSONObject(jsonString).getJSONObject("screens");
            Iterator<String> keys = jObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                JSONObject innerJObject = jObject.getJSONObject(key);
                Iterator<String> innerKeys = innerJObject.keys();

                answer = innerJObject.getString("answer");
                String image = innerJObject.getString("image");
                String button1 = innerJObject.getString("button_1");
                String button2 = innerJObject.getString("button_2");
                String button3 = innerJObject.getString("button_3");
                String button4 = innerJObject.getString("button_4");
                String button5 = innerJObject.getString("button_5");
                String button6 = innerJObject.getString("button_6");
                String button7 = innerJObject.getString("button_7");
                String button8 = innerJObject.getString("button_8");


                btn_1.setText(button1);
                btn_2.setText(button2);
                btn_3.setText(button3);
                btn_4.setText(button4);
                btn_5.setText(button5);
                btn_6.setText(button6);
                btn_7.setText(button7);
                btn_8.setText(button8);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method will switch to the new question if answer is correct
     **/
    public void help(View v) {
        EditText result = (EditText) findViewById(R.id.result);
        result.setText(answer);
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

        if (edit_text.getText().toString().equalsIgnoreCase(String.valueOf(answer))) { // HOW TO COMPARE?
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

    /**
     * This method responsible for the Action Bar menu
     **/
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; This adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            //noinspection RestrictedApi
            m.setOptionalIconsVisible(true);
        }

        return true;
    }

    /**
     * This method opens Browser intent with Info about the project
     **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button,
        // so long as you specify a parent actually in AndroidManifest.xml
        int id = item.getItemId();

        // no inspection SimplifiableIfStatement
        if (id == R.id.menu_about) {
            Uri uri = Uri.parse( "https://github.com/mobilotest/Kids_Game_Final_Project#kids-game---final-project-for-ucsc-extension" );
            startActivity( new Intent( Intent.ACTION_VIEW, uri ) );
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}