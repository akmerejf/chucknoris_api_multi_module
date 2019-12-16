package com.akmere.desafioguiabolso.data.repository

import com.akmere.desafioguiabolso.data.model.ChuckNorrisJoke
import io.reactivex.Single

interface ChuckNorrisJokeRepositoryContract{
    fun fetchCategories(): Single<List<String>>
    fun findByCategory(category: String): Single<ChuckNorrisJoke>
    fun findById()
}