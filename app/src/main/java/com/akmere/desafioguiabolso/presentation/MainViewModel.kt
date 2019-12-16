package com.akmere.desafioguiabolso.presentation

import com.akmere.desafioguiabolso.common.BaseSchedulerProvider
import com.akmere.desafioguiabolso.common.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val schedulerProvider: BaseSchedulerProvider
) : BaseViewModel() {}