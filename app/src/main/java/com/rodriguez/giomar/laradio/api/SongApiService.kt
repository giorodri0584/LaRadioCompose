package com.rodriguez.giomar.laradio.api

import android.util.Log
import com.rodriguez.giomar.laradio.data.entities.Song
import com.rodriguez.giomar.laradio.data.entities.SongResult
import com.rodriguez.giomar.laradio.other.Constants.BASE_URL
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SongApiService
@Inject constructor(
    private val httpClient: HttpClient
)
{
    suspend fun fetchAllSongs(): List<Song> {
        var songs: List<Song>
        val result: SongResult = httpClient.get("$BASE_URL/Stations")
        withContext(Dispatchers.IO) {
            songs = result.results
        }
        return songs
    }
}