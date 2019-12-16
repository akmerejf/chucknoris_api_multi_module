package com.akmere.desafioguiabolso.data.repository

import io.reactivex.Single

interface ChuckNorrisJokeRepositoryContract{
    fun fetchCategories(): Single<List<String>>
    fun findByCategory()
    fun findById()
}