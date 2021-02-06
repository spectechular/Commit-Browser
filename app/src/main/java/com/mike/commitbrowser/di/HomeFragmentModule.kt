package com.mike.commitbrowser.di

import com.mike.commitbrowser.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment
}