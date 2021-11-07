package com.app.yourtodo.util

import android.content.Context
import org.json.JSONObject
import java.nio.charset.Charset

class LocalReader {
    companion object {
        val authenFile = "user.json"

        fun readUsername(context: Context): String? {
            return context.openFileInput(authenFile).let {
                val bytes = it?.available()?.let { ByteArray(it) }
                it?.read(bytes)
                val gson = JSONObject(String(bytes!!, Charset.defaultCharset()))
                gson.getString("username")
            }
        }

        fun writeUsername(context: Context, filename: String, content: String) {
            context.openFileOutput(filename, Context.MODE_PRIVATE).apply {
                this.write(content.toByteArray())
            }
        }
    }
}