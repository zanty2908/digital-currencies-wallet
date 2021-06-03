package com.zanty.chresource.digitalcurrencieswallet.fake

import com.zanty.chresource.data.local.model.Currency
import com.zanty.chresource.data.network.model.response.CurrencyResponse

internal object DummyData {

    val currencyList = listOf(
        Currency(
            "LTC",
            "Litecoin",
            187.43,
            187.29,
            "https://cdn.coinhako.com/assets/wallet-ltc-e4ce25a8fb34c45d40165b6f4eecfbca2729c40c20611acd45ea0dc3ab50f8a6.png",
            "USD",
            "$187.43",
            "$187.29",
            false
        ),
        Currency(
            "NEO",
            "Neo",
            59.3956,
            58.9639,
            "https://cdn.coinhako.com/assets/wallet-neo-3fddd91057f65c159dbb601f503d637d144398d0573bf54d69fd6edf389827c7.png",
            "USD",
            "$58.9639",
            "$59.3956",
            false
        ),
        Currency(
            "BCH",
            "Bitcoin Cash",
            726.966,
            719.201,
            "https://cdn.coinhako.com/assets/wallet-bch-b111cca7bd56007d7c8594096c6aa17d1295392a851dbb57785546f055adced4.png",
            "USD",
            "$719.201",
            "$726.966",
            false
        )
    )

    val currencyResponseList = listOf<CurrencyResponse?>(
        CurrencyResponse(
            "Litecoin",
            "LTC",
            187.43,
            187.29,
            "USD",
            "https://cdn.coinhako.com/assets/wallet-ltc-e4ce25a8fb34c45d40165b6f4eecfbca2729c40c20611acd45ea0dc3ab50f8a6.png"
        ),
        CurrencyResponse(
            "Neo",
            "NEO",
            59.3956,
            58.9639,
            "USD",
            "https://cdn.coinhako.com/assets/wallet-neo-3fddd91057f65c159dbb601f503d637d144398d0573bf54d69fd6edf389827c7.png"
        ),
        CurrencyResponse(
            "Bitcoin Cash",
            "BCH",
            726.966,
            719.201,
            "USD",
            "https://cdn.coinhako.com/assets/wallet-bch-b111cca7bd56007d7c8594096c6aa17d1295392a851dbb57785546f055adced4.png"
        )
    )

}
