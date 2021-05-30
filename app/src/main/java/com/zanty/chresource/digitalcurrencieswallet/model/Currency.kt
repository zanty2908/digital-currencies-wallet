package com.zanty.chresource.digitalcurrencieswallet.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currency(
    val name: String,
    val base: String,
    val buyPrice: Double,
    val sellPrice: Double,
    val icon: String,
    val counter: String,
    val sellPriceDisplay: String,
    val buyPriceDisplay: String
) : Parcelable {
    fun contains(query: String) = base.contains(query, true) || name.contains(query, true)
}
