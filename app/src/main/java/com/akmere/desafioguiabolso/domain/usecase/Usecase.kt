package com.akmere.desafioguiabolso.domain.usecase

interface Usecase<T> {
    operator fun invoke(): T
}