package com.akmere.desafioguiabolso.common

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun providesRetrofit(httpClient: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .client(httpClient)
            .baseUrl(URLS.CHUCK_NORRIS)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    fun providesHttpClient(interceptor: Interceptor, cache: Cache): OkHttpClient =
        OkHttpClient
            .Builder()
            .addNetworkInterceptor(interceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .cache(cache)
            .build()

    @Provides
    @Singleton
    fun providesCache(context: Context): Cache = Cache(context.cacheDir, 5 * 1024 * 1024)
}