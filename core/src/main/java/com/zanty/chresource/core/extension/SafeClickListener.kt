package com.zanty.chresource.core.extension

import android.os.SystemClock
import android.view.View
import androidx.appcompat.widget.Toolbar

open class SafeClickListener(
    private var defaultInterval: Int = 900,
    private val onSafeCLick: (View) -> Unit
) : View.OnClickListener {
    private var lastTimeClicked: Long = 0
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v)
    }
}

fun View.setSafeOnClickListener(defaultInterval: Int = 900, onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener(defaultInterval) {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}

fun Toolbar.setSafeNavigationOnClickListener(
    defaultInterval: Int = 900,
    onSafeClick: (View) -> Unit
) {
    val safeClickListener = SafeClickListener(defaultInterval) {
        onSafeClick(it)
    }
    setNavigationOnClickListener(safeClickListener)
}
