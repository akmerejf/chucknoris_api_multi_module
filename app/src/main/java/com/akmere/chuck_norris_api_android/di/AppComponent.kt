package com.akmere.chuck_norris_api_android.di

import com.akmere.chuck_norris_api_android.ChuckNorrisApiApp
import com.akmere.chuck_norris_api_android.di.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules =
[
    AndroidBindingModule::class,
    ViewModelModule::class,
    AppModule::class,
    AndroidInjectionModule::class
])

interface AppComponent : AndroidInjector<ChuckNorrisApiApp>
{
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<ChuckNorrisApiApp>
}