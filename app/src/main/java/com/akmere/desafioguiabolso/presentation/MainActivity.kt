package com.akmere.desafioguiabolso.presentation

import android.os.Bundle
import androidx.lifecycle.Observer
import com.akmere.desafioguiabolso.common.BaseDaggerActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.widget.ArrayAdapter
import android.widget.Toast
import com.akmere.desafioguiabolso.R


class MainActivity : BaseDaggerActivity(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        initializeView()
        viewModel.showCategoryList()
    }


    private fun initializeView() {
        viewModel.categoriesSuccessStatus.observe(this, Observer { categoryList ->
            with(list_joke_categories) {
                adapter = ArrayAdapter<String>(
                    this@MainActivity,
                    android.R.layout.simple_list_item_1,
                    categoryList
                )
            }

        })

        viewModel.categoriesErrorStatus.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }
}


