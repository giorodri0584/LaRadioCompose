package com.rodriguez.giomar.laradio.players

import android.content.Context
import android.support.v4.media.MediaMetadataCompat
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.DataSource

class MediaPlayerAdapter(private val context: Context): PlayerAdapter(context) {
    private var player: SimpleExoPlayer? = null
    private lateinit var trackSelector: TrackSelector
    private lateinit var renderersFactory: DefaultRenderersFactory
    private lateinit var dataSourceFactory: DataSource.Factory

    private fun initializeExoPlayer() {
        if (player == null) {
            trackSelector = DefaultTrackSelector()
            renderersFactory
        }
    }

    override fun onPlay() {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        TODO("Not yet implemented")
    }

    override fun playFromMedia(metadata: MediaMetadataCompat?) {
        TODO("Not yet implemented")
    }

    override fun getCurrentMedia(): MediaMetadataCompat {
        TODO("Not yet implemented")
    }

    override fun isPlaying(): Boolean {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        TODO("Not yet implemented")
    }

    override fun seekTo(position: Long) {
        TODO("Not yet implemented")
    }

    override fun setVolume(volume: Float) {
        TODO("Not yet implemented")
    }
}