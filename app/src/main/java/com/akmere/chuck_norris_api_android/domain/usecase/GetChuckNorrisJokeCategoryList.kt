package com.akmere.chuck_norris_api_android.domain.usecase

import com.akmere.chuck_norris_api_android.data.repository.ChuckNorrisJokeRepositoryContract
import io.reactivex.Single
import javax.inject.Inject

class GetChuckNorrisJokeCategoryList @Inject constructor(private val repo: ChuckNorrisJokeRepositoryContract){

    operator fun invoke(): Single<Result<List<String>>> {
        val result: Single<Result<List<String>>>
        val source = repo.fetchCategories()

        result = source.map {
            Result.success(it)
        }.doOnError {
            Result.failure<Throwable>(it)
        }

        return result
    }

}