package com.akmere.desafioguiabolso.domain.usecase

import com.akmere.desafioguiabolso.data.model.ChuckNorrisJoke
import com.akmere.desafioguiabolso.data.repository.ChuckNorrisJokeRepositoryContract
import javax.inject.Inject

class GetChuckNorrisJokeCategoryList @Inject constructor(private val repo: ChuckNorrisJokeRepositoryContract) :
    Usecase<ChuckNorrisJoke> {

    override fun invoke(): ChuckNorrisJoke {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}