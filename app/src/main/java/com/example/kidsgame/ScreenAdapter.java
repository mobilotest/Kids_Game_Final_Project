package com.example.kidsgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.kidsgame.models.ScreenModel;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

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
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_main, null);
        }

        ImageView image_main;
        Button button1;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;
        Button button7;
        Button button8;

        ImageView main_image = (ImageView) convertView.findViewById(R.id.image_main);
        EditText result = (EditText) convertView.findViewById(R.id.result);
        Button oneButton = (Button) convertView.findViewById(R.id.button1);
        Button twoButton = (Button) convertView.findViewById(R.id.button2);
        Button threeButton = (Button) convertView.findViewById(R.id.button3);
        Button fourButton = (Button) convertView.findViewById(R.id.button4);
        Button fiveButton = (Button) convertView.findViewById(R.id.button5);
        Button sixButton = (Button) convertView.findViewById(R.id.button6);
        Button sevenButton = (Button) convertView.findViewById(R.id.button7);
        Button eightButton = (Button) convertView.findViewById(R.id.button8);


        screenModelList.setText(screenModelList.get(0).getImage());

        screenModelList.setText(screenModelList.get(2).getButton_1());
        screenModelList.setText(screenModelList.get(2).getButton_2());
        screenModelList.setText(screenModelList.get(2).getButton_3());
        screenModelList.setText(screenModelList.get(2).getButton_4());
        screenModelList.setText(screenModelList.get(2).getButton_5());
        screenModelList.setText(screenModelList.get(2).getButton_6());
        screenModelList.setText(screenModelList.get(2).getButton_7());
        screenModelList.setText(screenModelList.get(2).getButton_8());

        return convertView;
    }
}
