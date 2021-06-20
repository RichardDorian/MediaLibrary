package com.richarddorian.medialibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.richarddorian.medialibrary.MainActivity
import com.richarddorian.medialibrary.MediaModel
import com.richarddorian.medialibrary.MediaRepository.Singleton.mediaList
import com.richarddorian.medialibrary.R
import com.richarddorian.medialibrary.adapter.MediaAdapter
import com.richarddorian.medialibrary.adapter.MediaDecoration

class MediaFragment (private val context: MainActivity) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_media, container, false)
        val recylcerView = view.findViewById<RecyclerView>(R.id.media_recycler_view)
        recylcerView.adapter = MediaAdapter(context, mediaList, R.layout.item_vertical_media)
        recylcerView.layoutManager = LinearLayoutManager(context)
        recylcerView.addItemDecoration(MediaDecoration())

        return view
    }
}