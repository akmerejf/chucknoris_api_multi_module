@file:Suppress("unused")

package com.akmere.desafioguiabolso.di

import com.akmere.desafioguiabolso.common.ActivityScope
import com.akmere.desafioguiabolso.common.FragmentScope
import com.akmere.desafioguiabolso.presentation.CategoryListFragment
import com.akmere.desafioguiabolso.presentation.JokeDetailsFragment
import com.akmere.desafioguiabolso.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindCategoryListFragment(): CategoryListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindJokeDetailsFragment(): JokeDetailsFragment


}