package com.akmere.desafioguiabolso.data.repository

import com.akmere.desafioguiabolso.common.BaseSchedulerProvider
import com.akmere.desafioguiabolso.common.Repository
import com.akmere.desafioguiabolso.common.SchedulerProvider
import com.akmere.desafioguiabolso.data.source.ChuckNorrisApi
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class ChuckNorrisRepository @Inject constructor(
    api: ChuckNorrisApi) :
    Repository<ChuckNorrisApi>(api),
    ChuckNorrisJokeRepositoryContract {

    override fun fetchCategories(): Observable<List<String>> {
        return api.requestCategories()
    }

    override fun findByCategory() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}