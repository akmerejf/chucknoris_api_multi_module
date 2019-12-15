package com.akmere.desafioguiabolso.di

import android.content.Context
import android.content.SharedPreferences
import com.akmere.desafioguiabolso.GuiabolsoApp
import com.akmere.desafioguiabolso.common.NetworkModule
import com.akmere.desafioguiabolso.common.RxSchedulers
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
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
    fun providesContext(application: GuiabolsoApp): Context = application.applicationContext

    @Provides
    @Singleton
    fun providesRxSchedulers() = RxSchedulers(
        io = Schedulers.io(),
        main = AndroidSchedulers.mainThread(),
        computation = Schedulers.computation()
    )

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().create()
}
