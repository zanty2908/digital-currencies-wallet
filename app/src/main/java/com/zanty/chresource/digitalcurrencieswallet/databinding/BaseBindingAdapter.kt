package com.zanty.chresource.digitalcurrencieswallet.databinding

import androidx.appcompat.widget.AppCompatImageView
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
