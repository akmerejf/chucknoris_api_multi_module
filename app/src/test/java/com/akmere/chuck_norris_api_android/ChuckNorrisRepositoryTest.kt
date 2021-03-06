package com.akmere.chuck_norris_api_android

import com.akmere.chuck_norris_api_android.data.repository.ChuckNorrisJokeRepositoryContract
import com.akmere.chuck_norris_api_android.data.repository.ChuckNorrisRepository
import com.akmere.chuck_norris_api_android.data.source.ChuckNorrisApi
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException


@RunWith(JUnit4::class)
class ChuckNorrisRepositoryTest {

    @MockK
    private lateinit var api: ChuckNorrisApi

    private lateinit var server: MockWebServer
    private lateinit var chuckNorrisRepository: ChuckNorrisJokeRepositoryContract

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        server = MockWebServer()
        chuckNorrisRepository = ChuckNorrisRepository(api)
        server.start()
    }

    @Test
    fun fetchCategoriesShouldCallRequestCategories() {
        every { api.requestCategories() } returns Single.just(listOf())

        chuckNorrisRepository.fetchCategories()

        verify(exactly = 1) {
            api.requestCategories()
        }
    }
    @Test
    fun fetchCategoriesShouldComplete() {
        every { api.requestCategories() } returns Single.just(listOf())

        val observable = chuckNorrisRepository.fetchCategories()
        val testObserver = TestObserver<List<String>>()
        observable.subscribe(testObserver)

        testObserver.assertComplete()
    }

    @Test
    fun whenNoConnectionFetchCategoriesShouldContainsIOException() {
        val noInternetErrorException = IOException()

        every { api.requestCategories() } returns Single.error(noInternetErrorException)
        val observable = chuckNorrisRepository.fetchCategories()
        val testObserver = TestObserver<List<String>>()
        observable.subscribe(testObserver)

        testObserver.assertError(noInternetErrorException)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}