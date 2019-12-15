package com.akmere.desafioguiabolso.data.source

import com.akmere.desafioguiabolso.common.URLS
import retrofit2.http.GET
import retrofit2.http.Headers

interface ChuckNorrisApi{

    @GET(URLS.CATEGORY)
    @Headers("Content-Type: application/json")
    fun requestCategories()
}