package com.rodriguez.giomar.laradio.presentation.station_list_screen

import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.rodriguez.giomar.laradio.data.entities.Song
import com.rodriguez.giomar.laradio.model.Station

@Composable
fun StationListScreen(
    stations: List<Song>,
    currentSong: MediaMetadataCompat?,
    playbackState: PlaybackStateCompat?,
    onStationSelect: (Song) -> Unit
) {
    val cities = listOf<String>("Santiago", "Santo Domingo")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f)

        ) {
            items(cities) { city ->
                Text(
                    text = city,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp)
                )
                StationCityList(stations.filter { it.ciudad == city }) { station ->
                    onStationSelect(station)
                }
            }
        }
        Surface(
            elevation = 6.dp
        ) {
            Row (
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth()
                    .weight(0.1f)
                    .padding(horizontal = 16.dp),
                //.border(1.dp, Color.Black),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MiniPlayerComponent(song = currentSong, playbackState = playbackState)
            }
        }
    }
    
}