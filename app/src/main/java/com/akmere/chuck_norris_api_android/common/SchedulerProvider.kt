package com.akmere.chuck_norris_api_android.common

import io.reactivex.Scheduler


data class SchedulerProvider(
    private val io: Scheduler,
    private val ui: Scheduler,
    private val computation: Scheduler
) : BaseSchedulerProvider {
    override fun io(): Scheduler = io
    override fun ui(): Scheduler = ui
    override fun computation(): Scheduler = computation
}