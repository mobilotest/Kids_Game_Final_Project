package com.example.kidsgame;

import android.os.AsyncTask;

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

/**
 * This class will get a JSON from my web storage (my git project for now) and read it using different thread
 **/
public class JSONTask extends AsyncTask<String, String, List<ScreenModel>> {

    @Override
    protected List<ScreenModel> doInBackground(String... params) {
        HttpsURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpsURLConnection) url.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            String finalJSON = buffer.toString();

            JSONObject parentObject = new JSONObject(finalJSON);
            JSONArray parentArray = parentObject.getJSONArray("screens");

            List<ScreenModel> screenModelsList = new ArrayList<>();

            for (int i = 0; i < parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                ScreenModel screenModel = new ScreenModel();
                screenModel.setImage(finalObject.getString("image"));
                screenModel.setButton_1(finalObject.getString("button_1"));
                screenModel.setButton_2(finalObject.getString("button_2"));
                screenModel.setButton_3(finalObject.getString("button_3"));
                screenModel.setButton_4(finalObject.getString("button_4"));
                screenModel.setButton_5(finalObject.getString("button_5"));
                screenModel.setButton_6(finalObject.getString("button_6"));
                screenModel.setButton_7(finalObject.getString("button_7"));
                screenModel.setButton_8(finalObject.getString("button_8"));

                // added the final object to the list
                screenModelsList.add(screenModel);
            }
            return screenModelsList;

        } catch (MalformedURLException e) {
            https:
//github.com/mobilotest/Kids_Game_Final_Project/blob/master/app/src/main/assets/screens.json
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<ScreenModel> result) {
        super.onPostExecute(result);
        //TODO: need to set data to the list
//            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
    }
}
