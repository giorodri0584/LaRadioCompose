package com.rodriguez.giomar.laradio.presentation.station_list_screen

import android.support.v4.media.MediaMetadataCompat
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rodriguez.giomar.laradio.data.entities.Song
import com.rodriguez.giomar.laradio.model.Station

@Composable
fun StationListScreen(
    stations: List<Song>,
    currentSong: MediaMetadataCompat?,
    onStationSelect: (Song) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f)

        ) {
            items(6) {
                Text(
                    text = "Santiago",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp)
                )
                StationCityList(stations) { station ->
                    onStationSelect(station)
                }
            }
        }
        Row (
            modifier = Modifier
                .background(Color.Gray)
                .height(70.dp)
                .fillMaxWidth()
                .weight(0.1f),
                //.border(1.dp, Color.Black),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MiniPlayerComponent(currentSong)
        }
    }
    
}