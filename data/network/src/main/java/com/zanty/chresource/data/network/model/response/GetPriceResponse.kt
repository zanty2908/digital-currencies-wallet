package com.zanty.chresource.data.network.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetPricesResponse(@Json(name = "data") val `data`: List<CurrencyResponse?>?)

@JsonClass(generateAdapter = true)
data class CurrencyResponse(
    @Json(name = "name") val name: String?,
    @Json(name = "base") val base: String?,
    @Json(name = "buy_price") val buyPrice: Double?,
    @Json(name = "sell_price") val sellPrice: Double?,
    @Json(name = "counter") val counter: String?,
    @Json(name = "icon") val icon: String?
)
