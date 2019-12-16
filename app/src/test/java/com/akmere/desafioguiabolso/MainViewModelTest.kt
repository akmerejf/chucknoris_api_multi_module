package com.akmere.desafioguiabolso

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.akmere.desafioguiabolso.domain.usecase.GetChuckNorrisJokeCategoryList
import com.akmere.desafioguiabolso.presentation.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @MockK
    private lateinit var getChuckNorrisJokeCategoryList: GetChuckNorrisJokeCategoryList

    @MockK
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var schedulerProvider: TrampolineSchedulerProvider
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        schedulerProvider = TrampolineSchedulerProvider()
        viewModel =
            MainViewModel(compositeDisposable, getChuckNorrisJokeCategoryList, schedulerProvider)
    }

    @Test
    fun showCategoryListShouldCallGetChuckNorrisJokeCategoryListOnce() {
        every { getChuckNorrisJokeCategoryList() } returns Single.just(Result.success(listOf()))

        viewModel.showCategoryList()

        verify(exactly = 1) {
            getChuckNorrisJokeCategoryList()
        }
    }

    @Test
    fun whenGetChuckNorrisJokeCategoryListUsecaseIsSuccessShouldUpdateSuccessStatus() {
        every { getChuckNorrisJokeCategoryList() } returns Single.just(Result.success(listOf()))

        val observer: Observer<List<String>> = mockk(relaxed = true)

        viewModel.categoriesSuccessStatus.observeForever(observer)

        viewModel.showCategoryList()

        verify{
            observer.onChanged(any())
        }
    }

    @Test
    fun whenGetChuckNorrisJokeCategoryListUsecaseIsErrorShouldUpdateErrorStatus() {
        every { getChuckNorrisJokeCategoryList() } returns Single.just(Result.failure(NullPointerException()))

        val observer: Observer<String> = mockk(relaxed = true)

        viewModel.categoriesErrorStatus.observeForever(observer)

        viewModel.showCategoryList()

        verify{
            observer.onChanged(any())
        }
    }
}