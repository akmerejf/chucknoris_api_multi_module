package com.akmere.desafioguiabolso.di

import androidx.lifecycle.ViewModel
import com.akmere.desafioguiabolso.common.ViewModelKey
import com.akmere.desafioguiabolso.data.di.ChuckNorrisJokeRepositoryModule
import com.akmere.desafioguiabolso.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ChuckNorrisJokeRepositoryModule::class])
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun providesViewModel(viewModel: MainViewModel): ViewModel
}