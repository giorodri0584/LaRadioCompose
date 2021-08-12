package com.rodriguez.giomar.laradio.data.remote


import android.util.Log
import com.rodriguez.giomar.laradio.api.SongApiService
import com.rodriguez.giomar.laradio.data.entities.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MusicDatabase
@Inject constructor(
    private val songApiService: SongApiService
)
{
    suspend fun getAllSongs(): List<Song> {
        val songs = mutableListOf<Song>()
        val tempSongs = songApiService.fetchAllSongs()
        return tempSongs
    }
}