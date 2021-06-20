package com.richarddorian.medialibrary.adapter

import android.net.Uri
import android.util.JsonReader
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.richarddorian.medialibrary.*
import com.richarddorian.medialibrary.MediaRepository.Singleton.mediaList
import com.richarddorian.medialibrary.fragments.MediaFragment
import org.json.JSONArray
import org.json.JSONObject

class CategoryAdapter(private val context: MainActivity, private val categoryList: List<CategoryModel>, private val layoutId: Int) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val itemImage = view.findViewById<ImageView>(R.id.image_item)
        val itemName:TextView? = view.findViewById(R.id.name_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCategory = categoryList[position]
        val fileReader = FileReader(context)

        Glide.with(context).load(Uri.parse(currentCategory.coverUrl)).into(holder.itemImage)

        holder.itemName?.text = currentCategory.name

        holder.itemView.setOnClickListener {
            val categoryContent = fileReader.getParsedData().getJSONArray("categories")[currentCategory.index].toString()
            val categoryContentArray: JSONArray = JSONObject(categoryContent).getJSONArray("content")
            val mediaArrayList = arrayListOf<MediaModel>()
            for (index in 0 until categoryContentArray.length()) {
                val currentMedia = JSONObject(categoryContentArray.get(index).toString())
                val mediaItem = MediaModel(currentMedia.getString("name"), currentMedia.getString("description"), currentCategory.name, currentMedia.getString("url"), currentMedia.getString("coverUrl"))
                mediaArrayList.add(mediaItem)
            }
            val mediaRepository = MediaRepository(context)
            mediaRepository.updateData(mediaArrayList)

            val bottomNavigationView: BottomNavigationView = context.findViewById(R.id.bottom_navigation_view)
            bottomNavigationView.selectedItemId = R.id.media_page
        }

    }

}