package com.rodriguez.giomar.laradio.api

import com.rodriguez.giomar.laradio.data.entities.Song
import com.rodriguez.giomar.laradio.data.entities.SongResult
import com.rodriguez.giomar.laradio.other.Constants.BASE_URL
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class SongApiService
@Inject constructor(
    private val httpClient: HttpClient
)
{
    suspend fun fetchAllSongs(): List<Song> {
        val result: SongResult = httpClient.get("$BASE_URL/Stations")
        return listOf<Song>()
    }
}