package com.akmere.chuck_norris_api_android.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.akmere.chuck_norris_api_android.R
import com.akmere.chuck_norris_api_android.common.BaseDaggerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_joke_details.*

class JokeDetailsFragment : BaseDaggerFragment(R.layout.fragment_joke_details) {

    private val viewModel by viewModels<JokeDetailsViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeInformations()
        populateInformations()
    }

    private fun observeInformations() {
        viewModel.detailsSuccessStatus.observe(viewLifecycleOwner, Observer { joke ->
            joke_desc.text = joke.value
            joke_url.text = joke.url
            viewModel.showJokeImage(joke.iconUrl)
        })
        viewModel.detailsErrorStatus.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })

        viewModel.jokeImageStatus.observe(viewLifecycleOwner, Observer { image ->
            chuck_norris_image.setImageBitmap(image)
        })
    }

    private fun populateInformations() {
        arguments?.let { bundle ->
            val category = bundle.getString("category") ?: getString(R.string.default_category)
            requireActivity().toolbar.title = category
            viewModel.showDetails(category)
        }

    }

}
