
# ![Chuck Norris Api](https://api.chucknorris.io/) Android

Android App with two views, one showing a list of Chuck Norris Jokes Categories.
Another showing a random Chuck Norris Joke based on a chosen category.

This project uses MVVM, Usecases, Repositories and RxJava2, Retrofit2, Dagger2, Livedata, Navigation Component... etc.

### Architectural approach


![mvvm](https://github.com/akmerejf/chucknorris_api_android_app/blob/master/arquitetura_mvvm.png)


### A complete list of external dependencies
![dependencies.gradle](https://github.com/akmerejf/chucknorris_api_android_app/blob/master/dependencies.gradle)

## Getting Started

Clone this repo to your local machine and open it on Android Studio.
Wait until gradle sync completes


### Prerequisites

What things you need to install the software and how to install them

```
Kotlin 1.3.50
```

### Installing

> open project in Android Studio

### on Mac and Linux
> open terminal at project directory
``` 
./gradlew build 
```

> run the project

> navigate, test and *enjoy*


## Running the tests


> run the tests

```
./gradlew test
```

*or*

> Navigate to > /app/src/test/java

then right click and select ```Run Tests in Java```

### Break down into end to end tests

Tests are separated per architectural layer

### Repository
```
    @Test
    fun fetchCategoriesShouldCallRequestCategories() {
        every { api.requestCategories() } returns Single.just(listOf())

        chuckNorrisRepository.fetchCategories()

        verify(exactly = 1) {
            api.requestCategories()
        }
    }
```
### Usecase
```
    @Test
    fun whenFetchCategoriesIsSuccessShouldReturnResultSuccess() {
        every { chuckNorrisRepository.fetchCategories() } returns Single.just(listOf())

        val observable = usecase()
        val testObserver = TestObserver<Result<List<String>>>()

        observable.subscribe(testObserver)

        testObserver.values().map { assert(it.isSuccess) }
    }
```
### ViewModel

```
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
```

All tests share common schedulers and mock dependencies

## Authors

* **Akme-re Almeida** - *Initial work* - 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
