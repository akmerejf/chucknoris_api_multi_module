package com.akmere.chuck_norris_api_android.presentation

import com.akmere.chuck_norris_api_android.common.BaseSchedulerProvider
import com.akmere.chuck_norris_api_android.common.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val schedulerProvider: BaseSchedulerProvider
) : BaseViewModel() {}