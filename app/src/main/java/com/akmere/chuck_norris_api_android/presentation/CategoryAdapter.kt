package com.akmere.chuck_norris_api_android.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.akmere.chuck_norris_api_android.R

class CategoryAdapter(
    internal var context: Context,
    private val categoryItemCOmmand: CategoryItemCommand,
    private val resource: Int,
    private var items: List<String>
) : ArrayAdapter<String>(context, resource, items) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(context)

        val view = layoutInflater.inflate(resource, null, false)

        val categoryTitle: TextView = view.findViewById(R.id.category_title)

        val title = items[position]
        categoryTitle.text = title

        view.setOnClickListener {
            categoryItemCOmmand.onClicked(title)
        }
        //finally returning the view
        return view
    }
}

interface CategoryItemCommand{
    fun onClicked(category: String)
}
