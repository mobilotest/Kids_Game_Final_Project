package com.sergooo.kidsgame;

import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Screen>> {

    // Eng = 0; Rus = 1; Eng_anim = 2; Eng_tran = 3; Rus_anim = 4; Rus_tran = 5;
    private static int screensLoaderId = 0;

    String url_en = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_en.json?alt=media&token=ce3598d7-e90c-42d5-ade1-e9eb888a40e0";
    String url_ru = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_ru.json?alt=media&token=066628a0-0e3b-4cf9-b794-4457464ff880";
    String url_en_anim = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_en_anim.json?alt=media&token=e13f5bc6-a97a-43db-9592-bfb884402953";
    String url_en_tran = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_en_tran.json?alt=media&token=f82e2ab0-04b0-47dd-bac3-1ebc678a510c";
    String url_ru_anim = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_ru_anim.json?alt=media&token=52ef6307-1fd5-4b48-b82a-c5955be8565a";
    String url_ru_tran = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_ru_tran.json?alt=media&token=3fc9856f-f66e-484f-b177-0cdfcc0f9eae";

    private LoaderManager loaderManager = getLoaderManager();

    /**
     * Constant value for the screens loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */

    Screen currentScreen;
    private List<Screen> screens;
    private TextView about;
    private TextView russian;
    private TextView english;
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

    private ProgressBar progressBar;

    private Button help;
    private Button clear;
    private Button done;

    private String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.loading_indicator);
        help = (Button) findViewById(R.id.help);
        clear = (Button) findViewById(R.id.clear);
        done = (Button) findViewById(R.id.done);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected() && loaderManager != null) {
            loaderManager.initLoader(screensLoaderId, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            result.setText(R.string.no_internet_connection);
        }
    }

    private void fillOutMyScreen() {
        about = (TextView) findViewById(R.id.menu_about);
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

        Random random = new Random();
        int screenIndex = random.nextInt(screens.size());

        currentScreen = screens.get(screenIndex);

        btn_1.setText(currentScreen.getButton_1());
        btn_2.setText(currentScreen.getButton_2());
        btn_3.setText(currentScreen.getButton_3());
        btn_4.setText(currentScreen.getButton_4());
        btn_5.setText(currentScreen.getButton_5());
        btn_6.setText(currentScreen.getButton_6());
        btn_7.setText(currentScreen.getButton_7());
        btn_8.setText(currentScreen.getButton_8());

        // Get the news image from the json and set this image on the imageView
        Picasso.get().load(currentScreen.getImage()).into(image);
        image.setVisibility(View.VISIBLE);
        result.setText("");
    }

    /**
     * This method will switch to the new question if answer is correct
     **/
    public void help(View v) {
        result.setText(currentScreen.getAnswer());
    }

    /**
     * This method should clean the TextView box with the answer
     **/
    public void clear(View view) {
        result.setText("");
    }

    /**
     * This method will check if answer is correct or not and throw a toast message accordingly
     **/
    public void done(View view) throws InterruptedException {
        if (result.getText().toString().equalsIgnoreCase(String.valueOf(currentScreen.getAnswer()))) { // HOW TO COMPARE?
            toastMessage(R.string.great);
            fillOutMyScreen();
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
        temp = (String) result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 2
     **/
    public void two(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        temp = (String) result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 3
     **/
    public void three(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        temp = (String) result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 4
     **/
    public void four(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        temp = (String) result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 5
     **/
    public void five(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        temp = (String) result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 6
     **/
    public void six(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        temp = (String) result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 7
     **/
    public void seven(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        temp = (String) result.getText();
        result.setText(temp + "" + buttonText);
    }

    /**
     * This method put part of the word to the edit field from button 8
     **/
    public void eight(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        temp = (String) result.getText();
        result.setText(temp + "" + buttonText);
    }

    public void toastMessage(int resource) {
        Toast toast = Toast.makeText(getApplicationContext(), getText(resource), Toast.LENGTH_SHORT);
        TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
        toastMessage.setTextColor(Color.RED);
        toastMessage.setTextSize(40);
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
        if (menu instanceof MenuBuilder) {
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
            Uri uri = Uri.parse("https://github.com/mobilotest/Kids_Game_Final_Project#kids-game---final-project-for-ucsc-extension");
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
            return true;
        }

        // Handle presses on the action bar items ENG ans RUS
        if (id == R.id.flag_us) {
            screensLoaderId = 0;
            help.setText(R.string.help);
            clear.setText(R.string.clear);
            done.setText(R.string.done);
        } else if (id == R.id.flag_ru) {
            screensLoaderId = 1;
            help.setText(R.string.help_ru);
            clear.setText(R.string.clear_ru);
            done.setText(R.string.done_ru);
        } else if (id == R.id.transport) {
            if (screensLoaderId == 0 || screensLoaderId == 2 || screensLoaderId == 3) {
                screensLoaderId = 3;
                help.setText(R.string.help);
                clear.setText(R.string.clear);
                done.setText(R.string.done);
            } else if (screensLoaderId == 1 || screensLoaderId == 4 || screensLoaderId == 5) {
                screensLoaderId = 5;
                help.setText(R.string.help_ru);
                clear.setText(R.string.clear_ru);
                done.setText(R.string.done_ru);
            }
        } else if (id == R.id.animals) {
            if (screensLoaderId == 0 || screensLoaderId == 2 || screensLoaderId == 3) {
                screensLoaderId = 2;
                help.setText(R.string.help);
                clear.setText(R.string.clear);
                done.setText(R.string.done);
            } else if (screensLoaderId == 1 || screensLoaderId == 4 || screensLoaderId == 5) {
                screensLoaderId = 4;
                help.setText(R.string.help_ru);
                clear.setText(R.string.clear_ru);
                done.setText(R.string.done_ru);

            }
        }
        loaderManager.initLoader(screensLoaderId, null, this);
        return true;
    }

    @Override
    public Loader<List<Screen>> onCreateLoader(int i, Bundle bundle) {
        Uri baseUri = null;
        if (screensLoaderId == 0) {
            baseUri = Uri.parse(url_en);
        } else if (screensLoaderId == 1) {
            baseUri = Uri.parse(url_ru);
        } else if (screensLoaderId == 2) {
            baseUri = Uri.parse(url_en_anim);
        } else if (screensLoaderId == 3) {
            baseUri = Uri.parse(url_en_tran);
        } else if (screensLoaderId == 4) {
            baseUri = Uri.parse(url_ru_anim);
        } else if (screensLoaderId == 5) {
            baseUri = Uri.parse(url_ru_tran);
        }

        Uri.Builder uriBuilder = baseUri.buildUpon();
        uriBuilder.scheme("https").authority("content.guardianapis.com");
        uriBuilder.appendQueryParameter("q", "android");
        uriBuilder.appendQueryParameter("api-key", "test");
        uriBuilder.build();
        return new ScreenLoader(this, baseUri.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Screen>> loader, List<Screen> screens) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        this.screens = screens;
        fillOutMyScreen();
    }

    @Override
    public void onLoaderReset(Loader<List<Screen>> loader) {
    }
}