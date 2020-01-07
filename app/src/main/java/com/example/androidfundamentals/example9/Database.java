package com.example.androidfundamentals.example9;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {PersonEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract PersonDao personDao();

    private static Database DATABASE;

    public static Database getDatabase(Context context) {
        if (DATABASE == null) {
            DATABASE = Room.databaseBuilder(context,
                    Database.class,
                    "my_database")
                    .build();
        }
        return DATABASE;
    }

}