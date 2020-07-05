package com.testing.classapp;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;


public class MyApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
    }

    public static Context getContext(){
        return mContext;
    }
}

