package com.zanty.chresource.core.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

fun ViewGroup.inflate(@LayoutRes resource: Int): View =
    LayoutInflater.from(context).inflate(resource, this, false)

fun <B : ViewDataBinding> RecyclerView.ViewHolder.viewHolderBinding() = lazy {
    DataBindingUtil.bind<B>(itemView)
}

