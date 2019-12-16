package com.akmere.chuck_norris_api_android

import com.akmere.chuck_norris_api_android.common.BaseSchedulerProvider
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider(private val scheduler: TestScheduler) : BaseSchedulerProvider {
    override fun computation() = scheduler
    override fun ui() = scheduler
    override fun io() = scheduler
}