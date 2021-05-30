package com.zanty.chresource.digitalcurrencieswallet.databinding

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import coil.load
import com.zanty.chresource.digitalcurrencieswallet.R

@BindingAdapter("loadIcon")
fun AppCompatImageView.loadIcon(url: String?) {
    load(url) {
        crossfade(false)
        placeholder(R.drawable.ic_loading_icon)
        error(R.drawable.ic_bitcoin)
    }
}

@BindingAdapter("isVisible")
fun View.isVisible(visible: Boolean) {
    isVisible = visible
}

@BindingAdapter("isInvisible")
fun View.isInvisible(invisible: Boolean) {
    isInvisible = invisible
}
