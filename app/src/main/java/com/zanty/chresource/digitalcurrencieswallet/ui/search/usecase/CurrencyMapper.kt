package com.zanty.chresource.digitalcurrencieswallet.ui.search.usecase

import com.zanty.chresource.data.local.model.Currency
import com.zanty.chresource.data.network.model.response.CurrencyResponse
import java.text.NumberFormat
import javax.inject.Inject

class CurrencyMapper @Inject constructor() {

    private val format = NumberFormat.getCurrencyInstance()
        .apply {
            maximumFractionDigits = 10
            currency = java.util.Currency.getInstance("USD")
        }

    private fun Double?.formatCurrency() = format.format(this ?: 0.0)

    fun mapFromResponse(response: CurrencyResponse?): Currency? {
        val base = response?.base ?: return null
        return Currency(
            base,
            response.name ?: "",
            response.buyPrice ?: 0.0,
            response.sellPrice ?: 0.0,
            response.icon ?: "",
            response.counter ?: "",
            response.sellPrice.formatCurrency(),
            response.buyPrice.formatCurrency(),
            false
        )
    }

}
