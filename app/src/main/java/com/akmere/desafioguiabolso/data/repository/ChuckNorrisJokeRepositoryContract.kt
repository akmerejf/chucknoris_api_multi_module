package com.akmere.desafioguiabolso.data.repository

interface ChuckNorrisJokeRepositoryContract{
    fun findAll()
    fun findByCategory()
    fun findById()
}