package com.app.yourtodo.extension

import android.view.View
import android.view.inputmethod.InputMethodManager


fun View.hideKeyboard() {
    val inputMethodManager = context!!.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    inputMethodManager?.hideSoftInputFromWindow(this.windowToken, 0)
}