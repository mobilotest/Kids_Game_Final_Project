package com.sergooo.kidsgame;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads a list of screens by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class ScreenLoader extends AsyncTaskLoader<List<Screen>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = ScreenLoader.class.getName();

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link ScreenLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public ScreenLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Screen> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a screen with elements.
        String jsonString = QueryUtils.fetchScreensData(mUrl);
        try {
            return parseJSONfile(jsonString);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Screen> parseJSONfile(String jsonString) throws JSONException {
        JSONArray array = new JSONObject(jsonString).getJSONArray("screens");

        List<Screen> screens = new ArrayList<>();

        for (int i = 0, size = array.length(); i < size; i++) {
            JSONObject innerJObject = array.getJSONObject(i);

            String answer = innerJObject.getString("answer");
            String imageURL = innerJObject.getString("image");
            String button1 = innerJObject.getString("button_1");
            String button1audio = innerJObject.getString("button_1_audio");
            String button2 = innerJObject.getString("button_2");
            String button2audio = innerJObject.getString("button_2_audio");
            String button3 = innerJObject.getString("button_3");
            String button3audio = innerJObject.getString("button_3_audio");
            String button4 = innerJObject.getString("button_4");
            String button4audio = innerJObject.getString("button_4_audio");
            String button5 = innerJObject.getString("button_5");
            String button5audio = innerJObject.getString("button_5_audio");
            String button6 = innerJObject.getString("button_6");
            String button6audio = innerJObject.getString("button_6_audio");
            String button7 = innerJObject.getString("button_7");
            String button7audio = innerJObject.getString("button_7_audio");
            String button8 = innerJObject.getString("button_8");
            String button8audio = innerJObject.getString("button_8_audio");

            Screen screen = new Screen(imageURL, answer, button1, button1audio, button2, button2audio, button3, button3audio, button4, button4audio, button5, button5audio, button6, button6audio, button7, button7audio, button8, button8audio);
            screens.add(screen);
            System.out.println(screens);
        }
        return screens;
    }
}