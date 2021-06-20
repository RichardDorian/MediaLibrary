package com.richarddorian.medialibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.richarddorian.medialibrary.CategoryModel
import com.richarddorian.medialibrary.CategoryRepository.Singleton.categoryList
import com.richarddorian.medialibrary.MainActivity
import com.richarddorian.medialibrary.R
import com.richarddorian.medialibrary.adapter.CategoryAdapter
import com.richarddorian.medialibrary.adapter.CategoryDecoration

class CategoriesFragment(private val context: MainActivity) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_categories, container, false)

        val categoriesRecyclerView = view.findViewById<RecyclerView>(R.id.categories_recycler_view )
        categoriesRecyclerView.layoutManager = GridLayoutManager(context, 2)
        categoriesRecyclerView.adapter = CategoryAdapter(context, categoryList, R.layout.item_vertical_category)
        categoriesRecyclerView.addItemDecoration(CategoryDecoration())

        return view
    }

}