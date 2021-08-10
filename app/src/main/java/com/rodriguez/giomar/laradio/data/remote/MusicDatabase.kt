package com.rodriguez.giomar.laradio.data.remote


import com.rodriguez.giomar.laradio.data.entities.Song

class MusicDatabase {

    //private val firestore = FirebaseFirestore.getInstance()
    //private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        val songs = mutableListOf<Song>()
        songs.add(
            Song(
                mediaId = "TpN6e7IX3c",
                title = "La Bakana",
                subtitle = "Santo Domingo",
                songUrl = "https://radio4.domint.net:8028/stream",
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/elmeneoapp-e7c12.appspot.com/o/stations%2Fla-bakana-santo-domingo.png?alt=media&token=6142eddf-ea76-455e-a10e-e28674a23f22"
            )
        )
        songs.add(
            Song(
                mediaId = "fxfJbJDmP2",
                title = "Monumental",
                subtitle = "Santiago",
                songUrl = "https://radio4.domint.net:8030/stream",
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/elmeneoapp-e7c12.appspot.com/o/stations%2FMonumental.png?alt=media&token=bbdecd97-3d1f-41ac-a8e5-cf5390f1b195"
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