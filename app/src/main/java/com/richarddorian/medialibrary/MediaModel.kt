package com.richarddorian.medialibrary

class MediaModel (
        val name: String = "Media name",
        val description: String = "Media description",
        val category: String,
        val url: String = "https://example.com/fill_this",
        val coverUrl: String = "https://example.com/fill_this"
)