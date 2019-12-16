package com.akmere.chuck_norris_api_android.common

import javax.inject.Inject

open class Repository<A> @Inject constructor(
    protected val api: A
)