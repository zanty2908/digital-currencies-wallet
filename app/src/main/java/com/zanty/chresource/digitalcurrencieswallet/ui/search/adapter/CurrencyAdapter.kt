package com.zanty.chresource.digitalcurrencieswallet.ui.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.zanty.chresource.digitalcurrencieswallet.model.Currency

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency) =
        oldItem.base == newItem.base

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean =
        oldItem == newItem
}

class CurrencyAdapter : ListAdapter<Currency, ItemCurrencyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemCurrencyViewHolder(parent)

    override fun onBindViewHolder(holder: ItemCurrencyViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.bind(item)
    }

}
