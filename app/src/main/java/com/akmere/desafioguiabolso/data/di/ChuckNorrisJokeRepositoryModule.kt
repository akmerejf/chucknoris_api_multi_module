package com.akmere.desafioguiabolso.data.di

import com.akmere.desafioguiabolso.common.SchedulerProvider
import com.akmere.desafioguiabolso.data.source.ChuckNorrisApi
import com.akmere.desafioguiabolso.data.repository.ChuckNorrisJokeRepositoryContract
import com.akmere.desafioguiabolso.data.repository.ChuckNorrisRepository
import dagger.Module
import dagger.Provides

@Module
class ChuckNorrisJokeRepositoryModule{
    @Provides
    fun providesChuckNorrisJokeRepository(api: ChuckNorrisApi, schedulerProvider: SchedulerProvider): ChuckNorrisJokeRepositoryContract =
        ChuckNorrisRepository(api, schedulerProvider)
}