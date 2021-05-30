package com.zanty.chresource.core.network.mapping

import com.zanty.chresource.core.model.Currency
import com.zanty.chresource.data.network.model.response.CurrencyResponse
import com.zanty.chresource.data.network.model.response.GetPricesResponse

fun CurrencyResponse?.mapToDomain(): Currency? {
    val base = this?.base ?: return null
    return Currency(name ?: "", base, buyPrice ?: 0.0, sellPrice ?: 0.0, icon ?: "", counter ?: "")
}

fun GetPricesResponse?.mapToDomain(): List<Currency> {
    val data = this?.data ?: return emptyList()
    return data.mapNotNull { it?.mapToDomain() }
}
