package com.richarddorian.medialibrary

import org.json.JSONArray
import org.json.JSONObject

class CategoryRepository(private val context: MainActivity) {

    private val fileReader = FileReader(context)

    object Singleton {
        val categoryList = arrayListOf<CategoryModel>()
    }

    fun updateData() {
        val parsedData = fileReader.getParsedData()
        val categories: JSONArray = parsedData.getJSONArray("categories")
        for (index in 0 until categories.length()) {
            val currentCategory = JSONObject(categories.get(index).toString())
            Singleton.categoryList.add(CategoryModel(currentCategory.getString("name"), currentCategory.getString("description"), currentCategory.getString("coverUrl"), index))
        }
    }

}