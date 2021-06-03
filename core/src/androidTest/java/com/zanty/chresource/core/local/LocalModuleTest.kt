package com.zanty.chresource.core.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.zanty.chresource.core.fake.DummyData
import com.zanty.chresource.data.local.dao.CurrencyDao
import com.zanty.chresource.data.local.room.MainDatabase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest
class LocalModuleTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: MainDatabase
    private lateinit var currencyDao: CurrencyDao

    @Before
    fun setup() {
        hiltRule.inject()
        currencyDao = database.currencyDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertAndDelete() = runBlocking {
        val currency = DummyData.currency
        currencyDao.insert(currency)
        var list = currencyDao.getFavoriteList()
        assertThat(list).contains(currency)

        currencyDao.delete(currency.base)
        list = currencyDao.getFavoriteList()
        assertThat(list).isEmpty()
    }

}
