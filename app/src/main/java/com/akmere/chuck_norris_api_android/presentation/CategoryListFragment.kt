package com.akmere.chuck_norris_api_android.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.akmere.chuck_norris_api_android.R
import com.akmere.chuck_norris_api_android.common.BaseDaggerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_category_list.*


class CategoryListFragment : BaseDaggerFragment(R.layout.fragment_category_list),
    CategoryItemCommand {


    private val viewModel by viewModels<CategoryListViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeView()
        viewModel.showCategoryList()
        requireActivity().toolbar.title = getString(R.string.categories)
    }

    private fun initializeView() {
        viewModel.categoriesSuccessStatus.observe(this, Observer { categoryList ->
            with(list_joke_categories) {
                adapter = CategoryAdapter(
                    requireContext(),
                    this@CategoryListFragment,
                    R.layout.category_item,
                    categoryList
                )
            }

        })

        viewModel.categoriesErrorStatus.observe(this, Observer { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })
    }


    override fun onClicked(category: String) {
        val directions = CategoryListFragmentDirections
        findNavController().navigate(
            directions.actionCategoryListFragmentToJokeDetailsFragment(
                category
            )
        )
    }
}