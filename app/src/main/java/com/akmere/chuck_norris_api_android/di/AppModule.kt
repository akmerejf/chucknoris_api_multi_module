package com.akmere.chuck_norris_api_android.di

import android.content.Context
import com.akmere.chuck_norris_api_android.ChuckNorrisApiApp
import com.akmere.chuck_norris_api_android.common.BaseSchedulerProvider
import com.akmere.chuck_norris_api_android.common.NetworkModule
import com.akmere.chuck_norris_api_android.common.SchedulerProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module(
    includes =
    [
        NetworkModule::class
    ]
)
class AppModule {
    @Provides
    @Singleton
    fun providesContext(application: ChuckNorrisApiApp): Context = application.applicationContext

    @Provides
    @Singleton
    fun providesRxSchedulers(): BaseSchedulerProvider = SchedulerProvider(
        io = Schedulers.io(),
        ui = AndroidSchedulers.mainThread(),
        computation = Schedulers.computation()
    )

    @Provides
    @Singleton
    fun providesPicasso(context: Context, okHttp3Downloader: OkHttp3Downloader) =
        Picasso.Builder(context)
            .downloader(okHttp3Downloader)
            .build()


    @Provides
    @Singleton
    fun providesOkHttp3Downloader(context: Context) =
        OkHttp3Downloader(context)


    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().create()


}
