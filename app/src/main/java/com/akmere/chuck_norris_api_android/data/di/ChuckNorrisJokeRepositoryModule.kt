package com.akmere.chuck_norris_api_android.data.di

import com.akmere.chuck_norris_api_android.data.repository.ChuckNorrisJokeRepositoryContract
import com.akmere.chuck_norris_api_android.data.repository.ChuckNorrisRepository
import com.akmere.chuck_norris_api_android.data.source.ChuckNorrisApi
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkServiceModule::class])
class ChuckNorrisJokeRepositoryModule{
    @Provides
    fun providesChuckNorrisJokeRepository(api: ChuckNorrisApi): ChuckNorrisJokeRepositoryContract =
        ChuckNorrisRepository(api)
}