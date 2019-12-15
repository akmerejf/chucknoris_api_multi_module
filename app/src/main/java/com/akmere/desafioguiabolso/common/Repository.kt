
package com.akmere.desafioguiabolso.common

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class Repository<A> @Inject constructor(
    protected val api: A,
    protected val dispatcher: Scheduler = Schedulers.io())