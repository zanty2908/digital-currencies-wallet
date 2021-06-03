package com.zanty.chresource.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Currency(
    @PrimaryKey val base: String,
    val name: String,
    val buyPrice: Double,
    val sellPrice: Double,
    val icon: String,
    val counter: String,
    val sellPriceDisplay: String,
    val buyPriceDisplay: String,
    var isFavorite: Boolean
) : Parcelable
