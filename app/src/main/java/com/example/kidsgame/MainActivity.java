package com.example.kidsgame;

import android.content.Context;
import android.graphics.Bitmap;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kidsgame.models.ScreenModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create default options which will be used for every
        //  displayImage(...) call if no options will be passed to this method
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .build();
        ImageLoader.getInstance().init(config); // Do it on Application start

        EditText result = (EditText) findViewById(R.id.result);

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
            ScreenAdapter adapter = new ScreenAdapter(getApplicationContext(), R.layout.activity_main, result);
        }
    }

    public class ScreenAdapter extends ArrayAdapter {

        private List<ScreenModel> screenModelList;
        private int resource;
        private LayoutInflater inflater;

        public ScreenAdapter(@NonNull Context context, int resource, @NonNull List<ScreenModel> objects) {
            super(context, resource, objects);
            screenModelList = objects;
            this.resource = resource;
            inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;

            if (convertView == null) {
                convertView = inflater.inflate(resource, null);
                holder.image_main = (ImageView) convertView.findViewById(R.id.image_main);
                holder.result = (EditText) convertView.findViewById(R.id.result);
                holder.button1 = (Button) convertView.findViewById(R.id.button1);
                holder.button2 = (Button) convertView.findViewById(R.id.button2);
                holder.button3 = (Button) convertView.findViewById(R.id.button3);
                holder.button4 = (Button) convertView.findViewById(R.id.button4);
                holder.button5 = (Button) convertView.findViewById(R.id.button5);
                holder.button6 = (Button) convertView.findViewById(R.id.button6);
                holder.button7 = (Button) convertView.findViewById(R.id.button7);
                holder.button8 = (Button) convertView.findViewById(R.id.button8);
                convertView.setTag(holder);
            } else {
                holder = (ScreenAdapter.ViewHolder) convertView.getTag();
            }

            final ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);

            // Then later, when you want to display image
            ImageLoader.getInstance().displayImage(screenModelList.get(position).getImage(), holder.image_main, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    progressBar.setVisibility(View.GONE);
                }
            });

            holder.button1.setText(screenModelList.get(3).getButton_1());
            holder.button2.setText(screenModelList.get(4).getButton_2());
            holder.button3.setText(screenModelList.get(5).getButton_3());
            holder.button4.setText(screenModelList.get(6).getButton_4());
            holder.button5.setText(screenModelList.get(7).getButton_5());
            holder.button6.setText(screenModelList.get(8).getButton_6());
            holder.button7.setText(screenModelList.get(9).getButton_7());
            holder.button8.setText(screenModelList.get(10).getButton_8());

            return convertView;
        }

        public class ViewHolder {

            private ImageView image_main;
            private EditText result;
            private Button button1;
            private Button button2;
            private Button button3;
            private Button button4;
            private Button button5;
            private Button button6;
            private Button button7;
            private Button button8;
        }
    }
}