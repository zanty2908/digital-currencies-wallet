package com.zanty.chresource.digitalcurrencieswallet.ui.search.usecase

import com.zanty.chresource.data.local.model.Currency
import javax.inject.Inject

class SearchUseCase @Inject constructor() {

    val searchResultList = { list: List<Currency> ->
        { query: String ->
            list.filter { it.contains(query) }
                .sortedByDescending { it.sortBaseByQuery(query) }
        }
    }

    private fun Currency.sortBaseByQuery(query: String) = base.startsWith(query, true)

    private fun Currency.contains(query: String) =
        base.contains(query, true) || name.contains(query, true)

}
