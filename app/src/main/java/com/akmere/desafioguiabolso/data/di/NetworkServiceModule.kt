package com.akmere.desafioguiabolso.data.di

import com.akmere.desafioguiabolso.data.source.ChuckNorrisApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkServiceModule {
    @Provides
    fun providesUserService(retrofit: Retrofit): ChuckNorrisApi {
        val builder = retrofit.newBuilder().build()
        return builder.create(ChuckNorrisApi::class.java)
    }
}