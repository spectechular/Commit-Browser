package com.mike.commitbrowser.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Module(includes = [AndroidInjectionModule::class, ActivityModule::class])
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun provideContext(app: App): App
}