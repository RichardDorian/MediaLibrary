package com.richarddorian.medialibrary.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.richarddorian.medialibrary.MainActivity
import com.richarddorian.medialibrary.R
import org.w3c.dom.Document

class SettingsFragment(private val context: MainActivity) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_settings, container, false)
        view.findViewById<Button>(R.id.load_omp_button).setOnClickListener {
            requestOMPFile()
        }
        return view
    }

    private lateinit var requestFileIntent: Intent

    private fun requestOMPFile() {

    }


}