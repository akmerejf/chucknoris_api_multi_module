@file:Suppress("unused")

package com.akmere.chuck_norris_api_android.di

import com.akmere.chuck_norris_api_android.common.ActivityScope
import com.akmere.chuck_norris_api_android.common.FragmentScope
import com.akmere.chuck_norris_api_android.presentation.CategoryListFragment
import com.akmere.chuck_norris_api_android.presentation.JokeDetailsFragment
import com.akmere.chuck_norris_api_android.presentation.MainActivity
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