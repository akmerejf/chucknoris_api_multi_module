package com.akmere.desafioguiabolso.di

import com.akmere.desafioguiabolso.GuiabolsoApp
import com.akmere.desafioguiabolso.di.viewmodel.ViewModelModule
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

interface AppComponent : AndroidInjector<GuiabolsoApp>
{
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<GuiabolsoApp>
}