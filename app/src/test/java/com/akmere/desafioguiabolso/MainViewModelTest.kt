package com.akmere.desafioguiabolso

import com.akmere.desafioguiabolso.data.repository.ChuckNorrisRepository
import com.akmere.desafioguiabolso.domain.usecase.GetChuckNorrisJokeCategoryList
import com.akmere.desafioguiabolso.presentation.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before

class MainViewModelTest {

    @MockK
    private lateinit var getChuckNorrisJokeCategoryList: GetChuckNorrisJokeCategoryList

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = MainViewModel(getChuckNorrisJokeCategoryList)
    }


}