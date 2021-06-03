package com.zanty.chresource.core.fake

import com.zanty.chresource.data.local.model.Currency

internal object DummyData {
    val currency = Currency(
        "LTC",
        "Litecoin",
        187.43,
        187.29,
        "https://cdn.coinhako.com/assets/wallet-ltc-e4ce25a8fb34c45d40165b6f4eecfbca2729c40c20611acd45ea0dc3ab50f8a6.png",
        "USD",
        "$187.43",
        "$187.29",
        false
    )
}
