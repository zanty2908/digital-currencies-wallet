package com.zanty.chresource.core.di

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.hilt.android.EntryPointAccessors

val Fragment.injectCoreComponent: CoreComponent
    get() = EntryPointAccessors.fromApplication(requireActivity(), CoreComponent::class.java)

val Context.injectCoreComponent: CoreComponent
    get() = EntryPointAccessors.fromApplication(applicationContext, CoreComponent::class.java)
