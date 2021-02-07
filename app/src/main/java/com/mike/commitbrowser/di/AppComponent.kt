package com.mike.commitbrowser.di

import android.content.Context
import com.mike.commitbrowser.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AndroidInjectionModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    AppModule::class,
    HomeFragmentModule::class,
    NetworkModule::class,
    CommitRepositoryModule::class,
    CommitItemApiModule::class
    ]
)

interface AppComponent : AndroidInjector<App>{
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context) : AppComponent
    }
}