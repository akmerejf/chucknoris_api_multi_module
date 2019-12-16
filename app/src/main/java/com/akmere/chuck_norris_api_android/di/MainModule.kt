package com.akmere.chuck_norris_api_android.di

import androidx.lifecycle.ViewModel
import com.akmere.chuck_norris_api_android.common.ViewModelKey
import com.akmere.chuck_norris_api_android.data.di.ChuckNorrisJokeRepositoryModule
import com.akmere.chuck_norris_api_android.presentation.CategoryListViewModel
import com.akmere.chuck_norris_api_android.presentation.JokeDetailsViewModel
import com.akmere.chuck_norris_api_android.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ChuckNorrisJokeRepositoryModule::class])
abstract class MainModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun providesMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(JokeDetailsViewModel::class)
    abstract fun providesJokeDetailsViewModel(viewModel: JokeDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoryListViewModel::class)
    abstract fun providesCategoryListViewModel(viewModel: CategoryListViewModel): ViewModel
}