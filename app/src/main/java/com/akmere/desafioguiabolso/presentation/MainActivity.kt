package com.akmere.desafioguiabolso.presentation

import android.os.Bundle
import com.akmere.desafioguiabolso.R
import com.akmere.desafioguiabolso.common.BaseDaggerActivity

class MainActivity: BaseDaggerActivity(R.layout.activity_main){

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}