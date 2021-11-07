package com.app.yourtodo.converter

import androidx.room.TypeConverter
import java.util.Date


class DateConverter {

    @TypeConverter
    fun localDateToLong(value: Date?): Long? {
        return value?.time
    }

    @TypeConverter
    fun longToDate(value: Long?): Date? {
        return value?.let { Date(value) }
    }
}