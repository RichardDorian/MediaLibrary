package com.richarddorian.medialibrary.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.richarddorian.medialibrary.MainActivity
import com.richarddorian.medialibrary.MediaModel
import com.richarddorian.medialibrary.MediaPopup
import com.richarddorian.medialibrary.R

class MediaAdapter(val context: MainActivity, private val mediaList: List<MediaModel>, private val layoutId: Int) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val itemImage = view.findViewById<ImageView>(R.id.media_image)
        val itemName: TextView? = view.findViewById(R.id.media_name)
        val itemDescription: TextView? = view.findViewById(R.id.media_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mediaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMedia = mediaList[position]

        Glide.with(context).load(Uri.parse(currentMedia.coverUrl)).into(holder.itemImage)

        holder.itemName?.text = currentMedia.name
        holder.itemDescription?.text = currentMedia.description

        holder.itemView.setOnClickListener {
            MediaPopup(this, currentMedia).show()
        }
    }

}