package com.akmere.desafioguiabolso.data.repository

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single

interface ChuckNorrisJokeRepositoryContract{
    fun fetchCategories(): Observable<List<String>>
    fun findByCategory()
    fun findById()
}