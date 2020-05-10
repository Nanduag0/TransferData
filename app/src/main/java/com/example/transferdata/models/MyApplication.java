package com.example.transferdata.models;

import android.app.Application;

import com.example.transferdata.BuildConfig;
import com.example.transferdata.data.api.ApiHelper;
import com.example.transferdata.data.preferences.AppDataManager;

public class MyApplication  extends Application
{
    private AppDataManager appDataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            //Timber.plant(new Timber.DebugTree());
        } else {
           // Timber.plant(new ReleaseTree());
        }
    }


    public  AppDataManager getDataManager(){
        if(appDataManager == null){
            synchronized (ApiHelper.class){
                if(appDataManager == null){
                    appDataManager = new AppDataManager(this);
                }
            }
        }
        return appDataManager;
    }



}
