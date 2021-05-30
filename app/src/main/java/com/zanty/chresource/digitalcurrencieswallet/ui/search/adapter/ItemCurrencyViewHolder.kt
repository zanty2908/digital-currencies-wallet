package com.zanty.chresource.digitalcurrencieswallet.ui.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zanty.chresource.core.extension.inflate
import com.zanty.chresource.core.extension.setSafeOnClickListener
import com.zanty.chresource.core.extension.viewHolderBinding
import com.zanty.chresource.core.model.Currency
import com.zanty.chresource.digitalcurrencieswallet.R
import com.zanty.chresource.digitalcurrencieswallet.databinding.ItemCurrencyBinding

class ItemCurrencyViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_currency)) {

    private val mBinding by viewHolderBinding<ItemCurrencyBinding>()

    fun bind(data: Currency) = mBinding?.run {
        item = data

        btnFavorite.setSafeOnClickListener {
            it.isSelected = !it.isSelected
        }

        executePendingBindings()
    }

}
