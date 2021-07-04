package com.example.adapterupdown;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 2, entities = {Student.class})
abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao userDao();

}