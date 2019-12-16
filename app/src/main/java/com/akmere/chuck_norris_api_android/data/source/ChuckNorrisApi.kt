package com.akmere.chuck_norris_api_android.data.source

import com.akmere.chuck_norris_api_android.common.URLS
import com.akmere.chuck_norris_api_android.data.model.ChuckNorrisJoke
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET(URLS.CATEGORY)
    @Headers("Content-Type: application/json")
    fun requestCategories(): Single<List<String>>

    @GET(URLS.RANDOM_JOKE)
    @Headers("Content-Type: application/json")
    fun requestRandomJoke(@Query("category") category: String): Single<ChuckNorrisJoke>
}