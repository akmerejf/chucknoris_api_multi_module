package com.akmere.desafioguiabolso.common

import javax.inject.Inject

open class Repository<A> @Inject constructor(
    protected val api: A
)