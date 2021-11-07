package com.app.yourtodo.database

import android.content.Context
import androidx.room.Room

class DatabaseContext {

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun setup(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "todo").build()
            }
            return INSTANCE!!
        }
    }
}