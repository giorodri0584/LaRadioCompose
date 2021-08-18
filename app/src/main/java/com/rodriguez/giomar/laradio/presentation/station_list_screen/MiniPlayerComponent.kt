package com.rodriguez.giomar.laradio.presentation.station_list_screen

import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.PauseCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.rodriguez.giomar.laradio.R
import com.rodriguez.giomar.laradio.data.entities.Song
import com.rodriguez.giomar.laradio.exoplayer.isPlaying

@Composable
fun MiniPlayerComponent(
    song: MediaMetadataCompat?,
    playbackState: PlaybackStateCompat?
) {
    song?.let { media ->
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(
                    data = media.description.iconUri,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column() {
                Text(text = media.description.title.toString())
                Text(
                    text = media.description.subtitle.toString(),
                    style = MaterialTheme.typography.caption
                )
            }
        }
        if(playbackState?.isPlaying == true ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Outlined.PauseCircle,
                    contentDescription = "Play",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(width = 30.dp, height = 30.dp)
                )
            }
        } else {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.PlayArrow,
                    contentDescription = "Play",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(width = 30.dp, height = 30.dp)
                )
            }
        }

    }

}