package com.example.kidsgame;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Loads a list of news by using an AsyncTask to perform the
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
     * @param url     to load data from
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

        // Perform the network request, parse the response, and extract a list of news.
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
            String button2 = innerJObject.getString("button_2");
            String button3 = innerJObject.getString("button_3");
            String button4 = innerJObject.getString("button_4");
            String button5 = innerJObject.getString("button_5");
            String button6 = innerJObject.getString("button_6");
            String button7 = innerJObject.getString("button_7");
            String button8 = innerJObject.getString("button_8");

            Screen screen = new Screen(imageURL, answer, button1, button2, button3, button4, button5, button6, button7, button8);
            screens.add(screen);
            System.out.println(screens);
        }
        return screens;
    }

}