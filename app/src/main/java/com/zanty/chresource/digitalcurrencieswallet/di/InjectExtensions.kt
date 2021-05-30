package com.zanty.chresource.digitalcurrencieswallet.di

import com.zanty.chresource.core.di.injectCoreComponent
import com.zanty.chresource.digitalcurrencieswallet.ui.main.MainActivity
import com.zanty.chresource.digitalcurrencieswallet.ui.search.SearchCurrencyFragment

internal fun MainActivity.injectComponent() = DaggerMainComponent
    .factory()
    .build(injectCoreComponent)
    .inject(this)

internal fun SearchCurrencyFragment.injectComponent() = DaggerMainComponent
    .factory()
    .build(injectCoreComponent)
    .inject(this)
