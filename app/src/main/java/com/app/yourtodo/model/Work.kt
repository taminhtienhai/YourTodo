package com.app.yourtodo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "work")
data class Work (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "is_done")
    var isDone: Boolean = false,
    @ColumnInfo(name = "start_date")
    var startDate: Date? = Date(),
    @ColumnInfo(name = "due_date")
    var dueDate: Date? = null,
)