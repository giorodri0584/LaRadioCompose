package com.rodriguez.giomar.laradio.data.remote


import com.rodriguez.giomar.laradio.api.SongApiService
import com.rodriguez.giomar.laradio.data.entities.Song
import javax.inject.Inject

class MusicDatabase
@Inject constructor(
    private val apiService: SongApiService
)
{

    //private val firestore = FirebaseFirestore.getInstance()
    //private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        val songs = mutableListOf<Song>()
        val result = apiService.fetchAllSongs()
        songs.add(
            Song(
                objectId = "TpN6e7IX3c",
                name = "La Bakana",
                ciudad = "Santo Domingo",
                url = "https://radio4.domint.net:8028/stream",
                logoUrl = "https://firebasestorage.googleapis.com/v0/b/elmeneoapp-e7c12.appspot.com/o/stations%2Fla-bakana-santo-domingo.png?alt=media&token=6142eddf-ea76-455e-a10e-e28674a23f22"
            )
        )
        songs.add(
            Song(
                objectId = "fxfJbJDmP2",
                name = "Monumental",
                ciudad = "Santiago",
                url = "https://radio4.domint.net:8030/stream",
                logoUrl = "https://firebasestorage.googleapis.com/v0/b/elmeneoapp-e7c12.appspot.com/o/stations%2FMonumental.png?alt=media&token=bbdecd97-3d1f-41ac-a8e5-cf5390f1b195"
            )
        )
//        return try {
//            songCollection.get().await().toObjects(Song::class.java)
//        } catch(e: Exception) {
//            emptyList()
//        }

        return songs
    }
}