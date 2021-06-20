package com.richarddorian.medialibrary

class MediaRepository(private val context: MainActivity) {

    object Singleton {
        val mediaList = ArrayList<MediaModel>()
    }

    fun updateData(newList: ArrayList<MediaModel>) {
        Singleton.mediaList.clear()
        for (element in newList) {
            Singleton.mediaList.add(element)
        }
    }

}