package com.akmere.desafioguiabolso.presentation

import android.os.Bundle
import androidx.lifecycle.Observer
import com.akmere.desafioguiabolso.common.BaseDaggerActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_category_list.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.akmere.desafioguiabolso.R


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


