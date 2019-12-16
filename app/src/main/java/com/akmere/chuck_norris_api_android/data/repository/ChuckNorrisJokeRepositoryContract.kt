package com.akmere.chuck_norris_api_android.data.repository

import com.akmere.chuck_norris_api_android.data.model.ChuckNorrisJoke
import io.reactivex.Single

interface ChuckNorrisJokeRepositoryContract{
    fun fetchCategories(): Single<List<String>>
    fun findByCategory(category: String): Single<ChuckNorrisJoke>
    fun findById()
}