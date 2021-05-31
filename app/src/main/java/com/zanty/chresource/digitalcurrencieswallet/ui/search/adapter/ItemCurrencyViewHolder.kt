package com.zanty.chresource.digitalcurrencieswallet.ui.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zanty.chresource.core.extension.inflate
import com.zanty.chresource.core.extension.setSafeOnClickListener
import com.zanty.chresource.core.extension.viewHolderBinding
import com.zanty.chresource.digitalcurrencieswallet.R
import com.zanty.chresource.digitalcurrencieswallet.databinding.ItemCurrencyBinding
import com.zanty.chresource.data.local.model.Currency

class ItemCurrencyViewHolder(
    parent: ViewGroup,
    private val onClickFavorite: (Currency) -> Unit
) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_currency)) {

    private val mBinding by viewHolderBinding<ItemCurrencyBinding>()

    fun bind(data: Currency) = mBinding?.run {
        item = data
        btnFavorite.isSelected = data.isFavorite
        btnFavorite.setSafeOnClickListener {
            val expectSelected = !it.isSelected
            it.isSelected = expectSelected
            data.isFavorite = expectSelected
            onClickFavorite(data)
        }
        executePendingBindings()
    }

}
