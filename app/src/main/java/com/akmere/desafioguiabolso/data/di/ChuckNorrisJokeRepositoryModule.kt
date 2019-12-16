package com.akmere.desafioguiabolso.data.di

import com.akmere.desafioguiabolso.data.repository.ChuckNorrisJokeRepositoryContract
import com.akmere.desafioguiabolso.data.repository.ChuckNorrisRepository
import com.akmere.desafioguiabolso.data.source.ChuckNorrisApi
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkServiceModule::class])
class ChuckNorrisJokeRepositoryModule{
    @Provides
    fun providesChuckNorrisJokeRepository(api: ChuckNorrisApi): ChuckNorrisJokeRepositoryContract =
        ChuckNorrisRepository(api)
}