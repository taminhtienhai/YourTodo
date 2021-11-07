package com.app.yourtodo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.yourtodo.converter.DateConverter
import com.app.yourtodo.model.Recipe
import com.app.yourtodo.model.Work
import com.app.yourtodo.repo.RecipeDao
import com.app.yourtodo.repo.WorkDao

@Database(
    entities = [
        Work::class,
        Recipe::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun workDao(): WorkDao
    abstract fun recipeDao(): RecipeDao
}