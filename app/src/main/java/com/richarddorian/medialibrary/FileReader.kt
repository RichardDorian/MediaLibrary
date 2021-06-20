package com.richarddorian.medialibrary

import org.json.JSONObject


class FileReader(private val context: MainActivity) {

    fun getParsedData(): JSONObject {
        val fileContent: String = context.assets.open("private.omp").bufferedReader().use {
            it.readText()
        }
        return JSONObject(fileContent)
    }

}