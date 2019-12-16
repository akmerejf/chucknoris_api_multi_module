package com.akmere.chuck_norris_api_android.data.repository

import com.akmere.chuck_norris_api_android.common.Repository
import com.akmere.chuck_norris_api_android.data.model.ChuckNorrisJoke
import com.akmere.chuck_norris_api_android.data.source.ChuckNorrisApi
import io.reactivex.Single
import javax.inject.Inject

class ChuckNorrisRepository @Inject constructor(
    api: ChuckNorrisApi) :
    Repository<ChuckNorrisApi>(api),
    ChuckNorrisJokeRepositoryContract {

    override fun fetchCategories(): Single<List<String>> {
        return api.requestCategories()
    }

    override fun findByCategory(category: String): Single<ChuckNorrisJoke> {
        return api.requestRandomJoke(category)
    }

    override fun findById() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}