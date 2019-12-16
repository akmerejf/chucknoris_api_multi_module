package com.akmere.desafioguiabolso.di

import androidx.lifecycle.ViewModel
import com.akmere.desafioguiabolso.common.ViewModelKey
import com.akmere.desafioguiabolso.data.di.ChuckNorrisJokeRepositoryModule
import com.akmere.desafioguiabolso.presentation.CategoryListViewModel
import com.akmere.desafioguiabolso.presentation.JokeDetailsViewModel
import com.akmere.desafioguiabolso.presentation.MainViewModel
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