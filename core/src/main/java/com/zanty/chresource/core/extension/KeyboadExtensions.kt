package com.zanty.chresource.core.extension

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View?.hideSoftKeyboard() {
    this ?: return
    clearFocus()
    val inputMethod = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethod.hideSoftInputFromWindow(windowToken, 0)
}

fun View?.showSoftKeyboard() {
    this ?: return
    if (requestFocus()) {
        val inputMethod =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethod.showSoftInput(
            this,
            InputMethodManager.SHOW_IMPLICIT
        )
    }
}
