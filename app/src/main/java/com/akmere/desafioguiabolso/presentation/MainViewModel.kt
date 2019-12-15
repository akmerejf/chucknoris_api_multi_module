package com.akmere.desafioguiabolso.presentation

import androidx.lifecycle.ViewModel
import com.akmere.desafioguiabolso.domain.usecase.GetChuckNorrisJokeCategoryList
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getChuckNorrisJokeCategoryList:
    GetChuckNorrisJokeCategoryList
) : ViewModel() {
    //TODO("ab")
}