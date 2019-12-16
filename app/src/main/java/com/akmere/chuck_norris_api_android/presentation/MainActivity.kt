package com.akmere.chuck_norris_api_android.presentation

import android.os.Bundle
import com.akmere.chuck_norris_api_android.common.BaseDaggerActivity
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.akmere.chuck_norris_api_android.R


class MainActivity : BaseDaggerActivity(R.layout.activity_main) {
    private val navController: NavController by lazy { mainNavHostFragment.findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}


