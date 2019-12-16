package com.akmere.desafioguiabolso.domain.usecase

import io.reactivex.Single

interface Usecase<T> {
    operator fun invoke(): Single<Result<List<String>>>
}