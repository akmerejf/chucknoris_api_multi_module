package com.akmere.chuck_norris_api_android

import com.akmere.chuck_norris_api_android.common.BaseSchedulerProvider
import io.reactivex.schedulers.Schedulers

class TrampolineSchedulerProvider : BaseSchedulerProvider {
    override fun computation() = Schedulers.trampoline()
    override fun ui() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
}