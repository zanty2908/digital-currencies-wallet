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
) : Parcelable {
    val sellPriceDisplay: String get() = "$$sellPrice"
    val buyPriceDisplay: String get() = "$$buyPrice"
}
