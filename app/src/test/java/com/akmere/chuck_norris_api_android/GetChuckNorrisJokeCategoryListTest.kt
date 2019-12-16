package com.akmere.chuck_norris_api_android

import com.akmere.chuck_norris_api_android.data.repository.ChuckNorrisRepository
import com.akmere.chuck_norris_api_android.domain.usecase.GetChuckNorrisJokeCategoryList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

@RunWith(JUnit4::class)
class GetChuckNorrisJokeCategoryListTest {

    @MockK
    private lateinit var chuckNorrisRepository: ChuckNorrisRepository

    private lateinit var schedulerProvider: TrampolineSchedulerProvider
    private lateinit var usecase: GetChuckNorrisJokeCategoryList

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        schedulerProvider = TrampolineSchedulerProvider()
        usecase = GetChuckNorrisJokeCategoryList(chuckNorrisRepository)
    }

    @Test
    fun invokeShouldFetchJokeCategoriesOnce() {
        every { chuckNorrisRepository.fetchCategories() } returns Single.just(listOf())

        usecase()

        verify(exactly = 1) {
            chuckNorrisRepository.fetchCategories()
        }

    }

    @Test
    fun whenFetchCategoriesIsSuccessShouldReturnResultSuccess() {
        every { chuckNorrisRepository.fetchCategories() } returns Single.just(listOf())

        val observable = usecase()
        val testObserver = TestObserver<Result<List<String>>>()

        observable.subscribe(testObserver)

        testObserver.values().map { assert(it.isSuccess) }
    }

    @Test
    fun whenFetchCategoriesIsErrorShouldReturnResultFailure() {
        every { chuckNorrisRepository.fetchCategories() } returns Single.error(IOException())

        val observable = usecase()
        val testObserver = TestObserver<Result<List<String>>>()

        observable.subscribe(testObserver)

        testObserver.values().map { assert(it.isFailure) }
    }

}