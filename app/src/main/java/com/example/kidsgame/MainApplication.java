package com.example.kidsgame;

import android.app.Application;
import android.content.Context;

import com.example.kidsgame.helper.LocaleHelper;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
