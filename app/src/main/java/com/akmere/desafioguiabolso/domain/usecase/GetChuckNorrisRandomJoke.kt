package com.akmere.desafioguiabolso.domain.usecase

import com.akmere.desafioguiabolso.data.model.ChuckNorrisJoke
import com.akmere.desafioguiabolso.data.repository.ChuckNorrisJokeRepositoryContract
import io.reactivex.Single
import javax.inject.Inject

class GetChuckNorrisRandomJoke @Inject constructor(private val repo: ChuckNorrisJokeRepositoryContract){

    operator fun invoke(category: String): Single<Result<ChuckNorrisJoke>> {
        val result: Single<Result<ChuckNorrisJoke>>
        val source = repo.findByCategory(category = category)

        result = source.map {
            Result.success(it)
        }.doOnError {
            Result.failure<Throwable>(it)
        }
        return result
    }

}