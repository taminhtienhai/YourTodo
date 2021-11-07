package com.app.yourtodo.repo

import androidx.room.*
import com.app.yourtodo.model.Work

@Dao
interface WorkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWorks(vararg works: Work)

    @Delete
    suspend fun deleteWorks(vararg works: Work)

    @Query("SELECT * FROM work WHERE id = :id")
    suspend fun loadWorkById(id: Int): Work

    @Query("SELECT * FROM work")
    suspend fun loadAllWork(): List<Work>

    @Query("DELETE FROM work WHERE id = :id")
    suspend fun deleteWorkById(id: Int)
}