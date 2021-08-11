package com.rodriguez.giomar.laradio.presentation.station_list_screen

import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat.METADATA_KEY_MEDIA_ID
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodriguez.giomar.laradio.data.entities.Song
import com.rodriguez.giomar.laradio.exoplayer.MusicServiceConnection
import com.rodriguez.giomar.laradio.exoplayer.isPlayEnabled
import com.rodriguez.giomar.laradio.exoplayer.isPlaying
import com.rodriguez.giomar.laradio.exoplayer.isPrepared
import com.rodriguez.giomar.laradio.other.Constants.MEDIA_ROOT_ID
import com.rodriguez.giomar.laradio.other.Resource
import com.rodriguez.giomar.laradio.other.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class StationListScreenViewModel
@Inject constructor(
    private val musicServiceConnection: MusicServiceConnection
): ViewModel()
{
//    private val _mediaItems = MutableLiveData<Resource<List<Song>>>()
//    val mediaItems: LiveData<Resource<List<Song>>> = _mediaItems
    val mediaItems: MutableState<Resource<List<Song>>> = mutableStateOf(Resource.loading(null))

    val isConnected = musicServiceConnection.isConnected
    val networkError = musicServiceConnection.networkError
    val currentPlayingSong = musicServiceConnection.curPlayingSong
    private val playbackState = musicServiceConnection.playbackState
    init {
        //_mediaItems.postValue(Resource.loading(null))
        //mediaItems.value = Resource.loading(null)
        musicServiceConnection.subscribe(MEDIA_ROOT_ID, object : MediaBrowserCompat.SubscriptionCallback() {
            override fun onChildrenLoaded(
                parentId: String,
                children: MutableList<MediaBrowserCompat.MediaItem>
            ) {
                super.onChildrenLoaded(parentId, children)
                val items = children.map {
                    Song(
                        it.mediaId!!,
                        it.description.title.toString(),
                        it.description.subtitle.toString(),
                        it.description.mediaUri.toString(),
                        it.description.iconUri.toString()
                    )
                }
                //_mediaItems.postValue(Resource.success(items))
                mediaItems.value = Resource.success(items)
            }
        })
    }

    fun skipToNextSong() {
        musicServiceConnection.transportControls.skipToNext()
    }

    fun skipToPreviousSong() {
        musicServiceConnection.transportControls.skipToPrevious()
    }

    fun seekTo(pos: Long) {
        musicServiceConnection.transportControls.seekTo(pos)
    }

    fun playOrToggleSong(mediaItem: Song, toggle: Boolean = false) {
        val isPrepared = playbackState.value?.isPrepared ?: false
        if(isPrepared && mediaItem.objectId ==
            currentPlayingSong.value?.getString(METADATA_KEY_MEDIA_ID)) {
            playbackState.value?.let { playbackState ->
                when {
                    playbackState.isPlaying -> if(toggle) musicServiceConnection.transportControls.pause()
                    playbackState.isPlayEnabled -> musicServiceConnection.transportControls.play()
                    else -> Unit
                }
            }
        } else {
            musicServiceConnection.transportControls.playFromMediaId(mediaItem.objectId, null)
        }
    }

    override fun onCleared() {
        super.onCleared()
        musicServiceConnection.unsubscribe(MEDIA_ROOT_ID, object : MediaBrowserCompat.SubscriptionCallback() {})
    }
}