//package com.example.kidsgame;
//
//import android.content.Context;
//import android.location.Address;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//public class ReadJSON {
//    // Read the screens.json file and convert it to a java object.
//    public static MainActivity readJSONFile(Context context) throws IOException, JSONException {
//
//        // Read content of company.json
//        String jsonText = readText(context, R.raw.screens);
//
//
//        JSONObject jsonRoot = new JSONObject(jsonText);
//
//
//        String image = jsonRoot.getString("image");
//        String answer = jsonRoot.getString("answer");
//
//        JSONArray jsonArray = jsonRoot.getJSONArray("buttons");
//        String[] buttons = new String[jsonArray.length()];
//
//        for(int i=0;i < jsonArray.length();i++) {
//            buttons[i] = jsonArray.getString(i);
//        }
//
//        MainActivity screen = new MainActivity();
//        screen.setImage(image);
//        screen.setButtonsSyllables(buttons);
//        return screen;
//    }
//
//    private static String readText(Context context, int resId) throws IOException {
//        InputStream is = context.getResources().openRawResource(resId);
//        BufferedReader br= new BufferedReader(new InputStreamReader(is));
//        StringBuilder sb= new StringBuilder();
//        String s= null;
//        while((  s = br.readLine())!=null) {
//            sb.append(s);
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
//
//}
