package com.sergooo.kidsgame;

import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Screen>> {

    // Eng = 0; Rus = 1; Eng_anim = 2; Eng_tran = 3; Rus_anim = 4; Rus_tran = 5;
    private static int screensLoaderId = 0;

    String url_en = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_en.json?alt=media&token=1d214f19-2b67-412e-9dbc-4010b8ed5d17";
    String url_ru = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_ru.json?alt=media&token=ca9eb5f1-00da-4f2b-a25f-b3202c104d0c";
    String url_en_anim = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_en_anim.json?alt=media&token=71ab2761-3f14-4793-bff7-52d439e09922";
    String url_en_tran = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_en_tran.json?alt=media&token=841bc26a-4ec3-474e-8ae0-9d002ed7afca";
    String url_ru_anim = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_ru_anim.json?alt=media&token=9ac45d4e-cbfa-4290-b9f6-8f2689206dd6";
    String url_ru_tran = "https://firebasestorage.googleapis.com/v0/b/kidsgame-282600.appspot.com/o/screens_ru_tran.json?alt=media&token=afaa262b-9159-4893-90d2-42857830f12d";

    private LoaderManager loaderManager = getLoaderManager();

    /**
     * Constant value for the screens loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */

    Screen currentScreen;
    private List<Screen> screens;
    private TextView about;
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

    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        releaseMediaPlayer();
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

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

    private void fillOutMyScreen() throws IOException {
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

        btn_1.setText(currentScreen.getButton(0));
        btn_2.setText(currentScreen.getButton(1));
        btn_3.setText(currentScreen.getButton(2));
        btn_4.setText(currentScreen.getButton(3));
        btn_5.setText(currentScreen.getButton(4));
        btn_6.setText(currentScreen.getButton(5));
        btn_7.setText(currentScreen.getButton(6));
        btn_8.setText(currentScreen.getButton(7));

        // Get the Screen's image from the json and set this image on the imageView
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
    public void done(View view) throws InterruptedException, IOException {
        if (result.getText().toString().equalsIgnoreCase(String.valueOf(currentScreen.getAnswer()))) { // HOW TO COMPARE?
            toastMessage(R.string.great, true);
            mMediaPlayer = MediaPlayer.create(this, R.raw.good);
            mMediaPlayer.start();
            fillOutMyScreen();
        } else {
            toastMessage(R.string.fail, false);
            mMediaPlayer = MediaPlayer.create(this, R.raw.fail);
            mMediaPlayer.start();
        }
    }

    /**
     * This method put part of the word to the edit field from button 1
     **/
    public void syllablesClick(View v) {
        temp = (String) result.getText();
        String txtButton = currentScreen.getButton(Integer.valueOf((String)v.getTag()));
        result.setText(temp + "" + txtButton);
        if (screensLoaderId == 0 || screensLoaderId == 2 || screensLoaderId == 3) {
            playSyllable(txtButton.toLowerCase());
        } else {
            mMediaPlayer = MediaPlayer.create(this, R.raw.good);
            mMediaPlayer.start();
        }
    }

    public void toastMessage(int resource, boolean isCorrect) {
        Toast toast = Toast.makeText(getApplicationContext(), getText(resource), Toast.LENGTH_SHORT);
        TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
        int color = isCorrect ? Color.rgb(76,175,80) : Color.RED;
        toastMessage.setTextColor(color);
        toastMessage.setTextSize(36);
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

        // set app's sound mute/unmute to max
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int volume = audioManager.getStreamMaxVolume(audioManager.STREAM_MUSIC);
        if (id == R.id.menu_mute) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
        } else if (id == R.id.menu_unmute) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
        }

        // no inspection SimplifiableIfStatement
        if (id == R.id.menu_about) {
            Uri uri = Uri.parse("https://github.com/mobilotest/Kids_Game_Final_Project#kids-game---final-project-for-ucsc-extension");
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
            return true;
        }

        // Handle presses on the action bar items ENG ans RUS and Animals and Transport
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
        try {
            fillOutMyScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Screen>> loader) {
    }

    /**
     * This method just read one syllable based on tapped button.
     */
    public void playSyllable(String syllable) {

        releaseMediaPlayer();

        // Request audio focus for playback
        int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                // Use the music stream.
                AudioManager.STREAM_MUSIC,
                // Request permanent focus.
                AudioManager.AUDIOFOCUS_GAIN);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

            // Create and setup the {@link MediaPlayer} for the audio resource associated with the current button
            // mMediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(syllable, "raw", getPackageName()));
            int id = getResources().getIdentifier(syllable, "raw", getPackageName());
            mMediaPlayer = MediaPlayer.create(getApplicationContext(), id);

            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
        }
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Abandon audio focus when playback complete
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}