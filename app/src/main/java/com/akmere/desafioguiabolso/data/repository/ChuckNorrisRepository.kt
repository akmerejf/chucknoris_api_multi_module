package com.akmere.desafioguiabolso.data.repository

import com.akmere.desafioguiabolso.common.Repository
import com.akmere.desafioguiabolso.data.source.ChuckNorrisApi
import javax.inject.Inject

class ChuckNorrisRepository @Inject constructor(api: ChuckNorrisApi) :
    Repository<ChuckNorrisApi>(api),
    ChuckNorrisJokeRepositoryContract {

    override fun findAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByCategory() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}