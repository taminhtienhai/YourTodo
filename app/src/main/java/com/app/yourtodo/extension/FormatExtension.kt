package com.app.yourtodo.extension

import java.text.SimpleDateFormat
import java.util.*


fun Date.toISO(): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    return formatter.format(this)
}