package com.akmere.chuck_norris_api_android

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.akmere.chuck_norris_api_android.common.BaseSchedulerProvider
import com.akmere.chuck_norris_api_android.domain.usecase.GetChuckNorrisJokeCategoryList
import com.akmere.chuck_norris_api_android.presentation.CategoryListViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CategoryListViewModelTest {

    @MockK
    private lateinit var getChuckNorrisJokeCategoryList: GetChuckNorrisJokeCategoryList

    private lateinit var schedulerProvider: BaseSchedulerProvider
    private lateinit var viewModel: CategoryListViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        schedulerProvider = TrampolineSchedulerProvider()
        viewModel =
            CategoryListViewModel(getChuckNorrisJokeCategoryList, schedulerProvider)
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