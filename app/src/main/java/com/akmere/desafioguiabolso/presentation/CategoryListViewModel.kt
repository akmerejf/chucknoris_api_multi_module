package com.akmere.desafioguiabolso.presentation

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.akmere.desafioguiabolso.common.BaseSchedulerProvider
import com.akmere.desafioguiabolso.common.BaseViewModel
import com.akmere.desafioguiabolso.domain.usecase.GetChuckNorrisJokeCategoryList
import javax.inject.Inject

class CategoryListViewModel @Inject constructor(
    private val getChuckNorrisJokeCategoryList: GetChuckNorrisJokeCategoryList,
    private val schedulerProvider: BaseSchedulerProvider
) : BaseViewModel() {

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
                } catch (t: Throwable) {
                    mCategoriesErrorStatus.value = t.message
                }
            }, {
                mCategoriesErrorStatus.value = it.message
            })
    }
}