package com.rodriguez.giomar.laradio.presentation.station_list_screen

import android.support.v4.media.MediaMetadataCompat
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
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
    onStationSelect: (Song) -> Unit
) {
    val cities = listOf<String>("Santiago", "Santo Domingo")
    // Remember a SystemUiController
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )

        // setStatusBarsColor() and setNavigationBarsColor() also exist
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f)

        ) {
            items(cities) { city ->
                Text(
                    text = city,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp)
                )
                StationCityList(stations.filter { it.ciudad == city }) { station ->
                    onStationSelect(station)
                }
            }
        }
        Row (
            modifier = Modifier
                .background(Color(0xFF212121))
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