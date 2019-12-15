@file:Suppress("unused")

package com.akmere.desafioguiabolso.di

import com.akmere.desafioguiabolso.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidBindingModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindSplashActivity(): MainActivity
}