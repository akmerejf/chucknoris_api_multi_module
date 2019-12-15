package com.akmere.desafioguiabolso.common

import io.reactivex.Scheduler

data class RxSchedulers(
    val io: Scheduler,
    val main: Scheduler,
    val computation: Scheduler
)