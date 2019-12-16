package com.akmere.desafioguiabolso

import com.akmere.desafioguiabolso.common.BaseSchedulerProvider
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider(private val scheduler: TestScheduler) : BaseSchedulerProvider {
    override fun computation() = scheduler
    override fun ui() = scheduler
    override fun io() = scheduler
}