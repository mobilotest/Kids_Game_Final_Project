//package com.example.android.miwok;
//
//import android.content.Context;
//import android.media.AudioManager;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.kidsgame.R;
//
//import java.util.ArrayList;
//
//public class ReadJSON extends AppCompatActivity {
//
//    /**
//     * Handles playback of all the sound files
//     */
//    private MediaPlayer mMediaPlayer;
//    private AudioManager mAudioManager;
//    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            releaseMediaPlayer();
//        }
//    };
//
//    private Handler handler = new Handler();
//    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
//            new AudioManager.OnAudioFocusChangeListener() {
//                public void onAudioFocusChange(int focusChange) {
//                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//                        mMediaPlayer.pause();
//                        mMediaPlayer.seekTo(0);
//                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                        mMediaPlayer.start();
//                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                        // Your app has been granted audio focus again
//                        // Raise volume to normal, restart playback if necessary
//                        releaseMediaPlayer();
//                    }
//                }
//            };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.word_list);
//
//        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//
//        // create an array of words
//        final ArrayList<Word> words = new ArrayList<Word>();
//        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
//        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
//        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
//        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
//        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
//        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
//        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
//        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
//
//        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);
//        ListView listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(adapter);
//
//        // Set a click listener to play the audio when the list item is clicked on
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                // Get the {@link Word} object at the given position the user clicked on
//                Word word = words.get(position);
//
//                releaseMediaPlayer();
//
//                // Request audio focus for playback
//                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
//                        // Use the music stream.
//                        AudioManager.STREAM_MUSIC,
//                        // Request permanent focus.
//                        AudioManager.AUDIOFOCUS_GAIN);
//
//                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//
//                    // Create and setup the {@link MediaPlayer} for the audio resource associated
//                    // with the current word
//                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
//
//                    // Start the audio file
//                    mMediaPlayer.start();
//
//                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        // When the activity is stopped, release the media player resources because we won't
//        // be playing any more sounds.
//        releaseMediaPlayer();
//    }
//
//    /**
//     * Clean up the media player by releasing its resources.
//     */
//    private void releaseMediaPlayer() {
//        // If the media player is not null, then it may be currently playing a sound.
//        if (mMediaPlayer != null) {
//            // Regardless of the current state of the media player, release its resources
//            // because we no longer need it.
//            mMediaPlayer.release();
//
//            // Set the media player back to null. For our code, we've decided that
//            // setting the media player to null is an easy way to tell that the media player
//            // is not configured to play an audio file at the moment.
//            mMediaPlayer = null;
//
//            // Abandon audio focus when playback complete
//            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
//        }
//    }
//}