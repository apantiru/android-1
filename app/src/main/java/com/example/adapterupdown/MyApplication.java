package com.example.adapterupdown;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {
    private static MyApplication instanta;
    private static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        instanta = this;
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "students_database").build();
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }

    public static MyApplication getInstanta() {
        return instanta;
    }
}


