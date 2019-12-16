package com.akmere.desafioguiabolso.domain.usecase

import com.akmere.desafioguiabolso.data.repository.ChuckNorrisJokeRepositoryContract
import io.reactivex.Observable
import javax.inject.Inject

class GetChuckNorrisJokeCategoryList @Inject constructor(private val repo: ChuckNorrisJokeRepositoryContract) :
    Usecase<Observable<Result<List<String>>>>{

    override fun invoke(): Observable<Result<List<String>>> {
        val result: Observable<Result<List<String>>>
        val source = repo.fetchCategories()

        result = source.map {
            Result.success(it)
        }.doOnError {
            Result.failure<Throwable>(it)
        }

        return result
    }

}