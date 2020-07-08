package com.example.kidsgame;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

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

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("\n category:" + this.category);
//        sb.append("\n answer:" + this.answer);
//        sb.append("\n animals:" + this.animalName);
//        sb.append("\n transport:" + this.transportName);
//        if (this.buttonsSyllables != null) {
//            sb.append("\n buttons: ");
//            for (String buttons : this.buttonsSyllables) {
//                sb.append(buttons + ", ");
//            }
//        }
//        return sb.toString();
//    }

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

        HttpsURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/app/src/main/assets/screens.json");
            connection = (HttpsURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line = "";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            Toast.makeText(getApplicationContext(), buffer.toString(), Toast.LENGTH_LONG).show();

        } catch (MalformedURLException e) {https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/app/src/main/assets/screens.json
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        getJson();
    }

//    public void getJson() {
//        String json;
//        try {
//            InputStream is = getAssets().open("screens.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//
//            json = new String(buffer, "UTF-8");
//            JSONArray jsonArray = new JSONArray(json);
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject obj = jsonArray.getJSONObject(i);
//                if (obj.getString("answer").equals("ANT")) {
//                    myList.add(obj.getString("answer"));
//                    myList.add(obj.getString("image"));
//                    myList.add(obj.getString("button_1"));
//                    myList.add(obj.getString("button_2"));
//                    myList.add(obj.getString("button_3"));
//                    myList.add(obj.getString("button_4"));
//                    myList.add(obj.getString("button_5"));
//                    myList.add(obj.getString("button_6"));
//                    myList.add(obj.getString("button_7"));
//                    myList.add(obj.getString("button_8"));
//                }
//            }

//            main_image.setImageResource(myList.get(0));
//            result.getText().toString().equals(str_animal);
//
//            oneButton.setText(btn1_resource_text);
//            twoButton.setText(btn2_resource_text);
//            threeButton.setText(btn3_resource_text);
//            fourButton.setText(btn4_resource_text);
//            fiveButton.setText(btn5_resource_text);
//            sixButton.setText(btn6_resource_text);
//            sevenButton.setText(btn7_resource_text);
//            eightButton.setText(btn8_resource_text);
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        Toast.makeText(getApplicationContext(), myList.toString(), Toast.LENGTH_LONG).show();
//    }


    /*

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentNews = (News) getItem(position);

        if (currentNews != null) {

            // Find the ImageView in the list_item.xml layout with the ID
            ImageView placeImage = (ImageView) listItemView.findViewById(R.id.img_newspic);
            // Get the news image from the current News and set this image on the imageView
            Picasso.get().load(currentNews.getThumbnail()).into(placeImage);
            if (currentNews.getThumbnail() != null) {
                placeImage.setVisibility(View.VISIBLE);
            } else {
                placeImage.setVisibility(View.GONE);
            }
        }

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView headerTextView = (TextView) listItemView.findViewById(R.id.tv_header);
        // Get the news header from the current News object and
        // set this text on the header TextView
        headerTextView.setText(currentNews.getNewsHeader());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.tv_author);
        // Get the news body from the current News object and
        // set this text on the body TextView
        authorTextView.setText("Author: " + currentNews.getAuthor());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.tv_section);
        // Get the Section from the current News object and
        // set this text on the Section TextView
        sectionTextView.setText(currentNews.getSection());
        int color = getSectionName(sectionTextView.toString());
        sectionTextView.setTextColor(color);

        // Create a new Date object from the time in milliseconds of the news
        // Find the TextView with view ID date
        TextView date = (TextView) listItemView.findViewById(R.id.tv_date_time);
        // Format the date string (i.e. "Mar 3, 1984, 4:30 PM")
        SimpleDateFormat newDateFormat = new SimpleDateFormat("LLL dd, yyyy, h:mm a");
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String getDate = currentNews.getDate().toString().substring(0, 10);
        // Display the date of the current news in that TextView
        try {
            Date newDate = oldDateFormat.parse(getDate);
            date.setText(newDateFormat.format(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
     */

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
//    Ant(R.drawable.ant, R.string.ant, R.string.thirtyfour, R.string.three, R.string.eight, R.string.twentynine, R.string.thirtyone, R.string.fiftythree, R.string.fourteen, R.string.twelve);
//        Cow(R.drawable.ant, R.string.cow, R.string.fifteen, R.string.four, R.string.five, R.string.twentynine, R.string.thirtyone, R.string.seven, R.string.twenty, R.string.six);

// HOW TO SWITCH

/**
 * //     * This method for cat only so far
 * //
 **/
//    public void Cat(int img_resource, int str_animal, int btn1_resource_text, int btn2_resource_text, int btn3_resource_text, int btn4_resource_text, int btn5_resource_text, int btn6_resource_text, int btn7_resource_text, int btn8_resource_text) {
//
//        ImageView main_image = (ImageView) findViewById(R.id.image_main);
//        EditText result = (EditText) findViewById(R.id.result);
//
//        Button oneButton = (Button) findViewById(R.id.button1);
//        Button twoButton = (Button) findViewById(R.id.button2);
//        Button threeButton = (Button) findViewById(R.id.button3);
//        Button fourButton = (Button) findViewById(R.id.button4);
//        Button fiveButton = (Button) findViewById(R.id.button5);
//        Button sixButton = (Button) findViewById(R.id.button6);
//        Button sevenButton = (Button) findViewById(R.id.button7);
//        Button eightButton = (Button) findViewById(R.id.button8);
//
//        main_image.setImageResource(img_resource);
//        result.getText().toString().equals(str_animal);
//
//        oneButton.setText(btn1_resource_text);
//        twoButton.setText(btn2_resource_text);
//        threeButton.setText(btn3_resource_text);
//        fourButton.setText(btn4_resource_text);
//        fiveButton.setText(btn5_resource_text);
//        sixButton.setText(btn6_resource_text);
//        sevenButton.setText(btn7_resource_text);
//        eightButton.setText(btn8_resource_text);
//    }
//
//    /**
//     * This method is just for ant
//     **/
//    public void Ant(int img_resource, int str_animal, int btn1_resource_text, int btn2_resource_text, int btn3_resource_text, int btn4_resource_text, int btn5_resource_text, int btn6_resource_text, int btn7_resource_text, int btn8_resource_text) {
//
//        ImageView main_image = (ImageView) findViewById(R.id.image_main);
//        EditText result = (EditText) findViewById(R.id.result);
//
//        Button oneButton = (Button) findViewById(R.id.button1);
//        Button twoButton = (Button) findViewById(R.id.button2);
//        Button threeButton = (Button) findViewById(R.id.button3);
//        Button fourButton = (Button) findViewById(R.id.button4);
//        Button fiveButton = (Button) findViewById(R.id.button5);
//        Button sixButton = (Button) findViewById(R.id.button6);
//        Button sevenButton = (Button) findViewById(R.id.button7);
//        Button eightButton = (Button) findViewById(R.id.button8);
//
//        main_image.setImageResource(img_resource);
//        result.getText().toString().equals(str_animal);
//
//        oneButton.setText(btn1_resource_text);
//        twoButton.setText(btn2_resource_text);
//        threeButton.setText(btn3_resource_text);
//        fourButton.setText(btn4_resource_text);
//        fiveButton.setText(btn5_resource_text);
//        sixButton.setText(btn6_resource_text);
//        sevenButton.setText(btn7_resource_text);
//        eightButton.setText(btn8_resource_text);
//    }
//
//    public void Cow(int img_resource, int str_animal, int btn1_resource_text, int btn2_resource_text, int btn3_resource_text, int btn4_resource_text, int btn5_resource_text, int btn6_resource_text, int btn7_resource_text, int btn8_resource_text) {
//
//        ImageView main_image = (ImageView) findViewById(R.id.image_main);
//        EditText result = (EditText) findViewById(R.id.result);
//
//        Button oneButton = (Button) findViewById(R.id.button1);
//        Button twoButton = (Button) findViewById(R.id.button2);
//        Button threeButton = (Button) findViewById(R.id.button3);
//        Button fourButton = (Button) findViewById(R.id.button4);
//        Button fiveButton = (Button) findViewById(R.id.button5);
//        Button sixButton = (Button) findViewById(R.id.button6);
//        Button sevenButton = (Button) findViewById(R.id.button7);
//        Button eightButton = (Button) findViewById(R.id.button8);
//
//        main_image.setImageResource(img_resource);
//        result.getText().toString().equals(str_animal);
//
//        oneButton.setText(btn1_resource_text);
//        twoButton.setText(btn2_resource_text);
//        threeButton.setText(btn3_resource_text);
//        fourButton.setText(btn4_resource_text);
//        fiveButton.setText(btn5_resource_text);
//        sixButton.setText(btn6_resource_text);
//        sevenButton.setText(btn7_resource_text);
//        eightButton.setText(btn8_resource_text);
//    }

