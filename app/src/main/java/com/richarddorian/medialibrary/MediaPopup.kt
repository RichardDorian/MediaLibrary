package com.richarddorian.medialibrary

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.richarddorian.medialibrary.adapter.MediaAdapter


class MediaPopup(private val adapter: MediaAdapter, private val currentMedia: MediaModel) : Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.media_popup)
        setupComponents()
        setupCloseButton()
        setupPlayButton()
    }

    private fun setupPlayButton() {
        findViewById<ImageView>(R.id.popup_play).setOnClickListener {
            val uri = Uri.parse("vlc://" + currentMedia.url)
            startActivity(context, Intent(Intent.ACTION_VIEW, uri), Bundle(Bundle.EMPTY))
        }
    }

    private fun setupCloseButton() {
        findViewById<ImageView>(R.id.popup_close).setOnClickListener {
            dismiss()
        }
    }

    private fun setupComponents() {
        val mediaImage = findViewById<ImageView>(R.id.popup_image)
        Glide.with(adapter.context).load(currentMedia.coverUrl).into(mediaImage)

        findViewById<TextView>(R.id.popup_media_name).text = currentMedia.name
        findViewById<TextView>(R.id.popup_category_value).text = currentMedia.category
        findViewById<TextView>(R.id.popup_description_value).text = currentMedia.description
    }

}