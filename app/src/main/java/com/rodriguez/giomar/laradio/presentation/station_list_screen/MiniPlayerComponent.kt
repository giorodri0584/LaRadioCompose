package com.rodriguez.giomar.laradio.presentation.station_list_screen

import android.support.v4.media.MediaMetadataCompat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.rodriguez.giomar.laradio.R
import com.rodriguez.giomar.laradio.data.entities.Song

@Composable
fun MiniPlayerComponent(
    song: MediaMetadataCompat?
) {
    song?.let { media ->
        Row() {
            Image(
                painter = rememberImagePainter(
                    data = media.description.iconUri,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            Column() {
                Text(text = media.description.title.toString())
                Text(
                    text = media.description.subtitle.toString(),
                    style = MaterialTheme.typography.caption
                )
            }
        }

        Image(
            painterResource(id = R.drawable.ic_play),
            contentDescription = "Play")

    }

}