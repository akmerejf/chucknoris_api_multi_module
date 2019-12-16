package com.akmere.desafioguiabolso.presentation

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akmere.desafioguiabolso.common.BaseSchedulerProvider
import com.akmere.desafioguiabolso.common.BaseViewModel
import com.akmere.desafioguiabolso.common.addToCompositeDisposable
import com.akmere.desafioguiabolso.domain.usecase.GetChuckNorrisJokeCategoryList
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(
    compositeDisposable: CompositeDisposable,
    private val getChuckNorrisJokeCategoryList: GetChuckNorrisJokeCategoryList,
    private val schedulerProvider: BaseSchedulerProvider
) : BaseViewModel(compositeDisposable) {

    private val mCategoriesSuccessStatus = MutableLiveData<List<String>>()
    val categoriesSuccessStatus: LiveData<List<String>>
        get() = mCategoriesSuccessStatus

    private val mCategoriesErrorStatus = MutableLiveData<String>()
    val categoriesErrorStatus: LiveData<String>
        get() = mCategoriesErrorStatus

    @SuppressLint("CheckResult")
    fun showCategoryList() {
        getChuckNorrisJokeCategoryList()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                try {
                    mCategoriesSuccessStatus.value = it.getOrThrow()
                }catch (t: Throwable){
                    mCategoriesErrorStatus.value = t.message
                }
            }, {
                mCategoriesErrorStatus.value = it.message
            } )

    }
}