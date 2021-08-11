package com.rodriguez.giomar.laradio.data.entities

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
data class Song(
    val objectId: String = "",
    val name: String = "",
    val ciudad: String = "",
    val url: String = "",
    val logoUrl: String = ""
)


@Serializable
data class SongResult(val results: List<Song>)