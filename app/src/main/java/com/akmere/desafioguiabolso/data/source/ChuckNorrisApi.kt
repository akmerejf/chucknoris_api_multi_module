package com.akmere.desafioguiabolso.data.source

import com.akmere.desafioguiabolso.common.URLS
import com.akmere.desafioguiabolso.data.model.ChuckNorrisJoke
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface ChuckNorrisApi {

    @GET(URLS.CATEGORY)
    @Headers("Content-Type: application/json")
    fun requestCategories(): Single<List<String>>
}