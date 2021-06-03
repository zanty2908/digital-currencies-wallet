package com.zanty.chresource.digitalcurrencieswallet.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.zanty.chresource.digitalcurrencieswallet.fake.DummyData
import com.zanty.chresource.digitalcurrencieswallet.ui.search.usecase.CurrencyMapper
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest
class CurrencyMapperTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var currencyMapper: CurrencyMapper

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun checkMappingItemResponseData() = runBlockingTest {
        val itemResponse = DummyData.currencyResponseList[0]
        val mappingItem = currencyMapper.mapFromResponse(itemResponse)
        val expectItem = DummyData.currencyList[0]
        assertThat(mappingItem?.base).isEqualTo(expectItem.base)
        assertThat(mappingItem?.name).isEqualTo(expectItem.name)
        assertThat(mappingItem?.icon).isEqualTo(expectItem.icon)
        assertThat(mappingItem?.buyPrice).isEqualTo(expectItem.buyPrice)
        assertThat(mappingItem?.sellPrice).isEqualTo(expectItem.sellPrice)
        assertThat(mappingItem?.isFavorite).isEqualTo(expectItem.isFavorite)
    }

    @Test
    fun checkMappingResponseData() = runBlockingTest {
        val responseList = DummyData.currencyResponseList
        val mappingList = responseList.mapNotNull(currencyMapper::mapFromResponse)

        val expectList = DummyData.currencyList
        assertThat(expectList[0].base).isEqualTo(mappingList[0].base)
        assertThat(expectList[1].base).isEqualTo(mappingList[1].base)
        assertThat(expectList[2].base).isEqualTo(mappingList[2].base)
    }

}
