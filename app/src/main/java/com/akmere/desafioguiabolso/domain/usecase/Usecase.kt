package com.akmere.desafioguiabolso.domain.usecase

import io.reactivex.Observable

interface Usecase<T> {
    operator fun invoke(): Observable<Result<List<String>>>
}