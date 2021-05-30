package com.zanty.chresource.digitalcurrencieswallet.ui.main

import androidx.lifecycle.ViewModel
import com.zanty.chresource.core.executor.PostExecutionThread
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val postExecutionThread: PostExecutionThread
): ViewModel()