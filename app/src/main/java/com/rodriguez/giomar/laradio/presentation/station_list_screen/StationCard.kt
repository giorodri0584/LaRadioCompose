package com.rodriguez.giomar.laradio.presentation.station_list_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.rodriguez.giomar.laradio.data.entities.Song
import com.rodriguez.giomar.laradio.model.Station

@Composable
fun StationCard(
    station: Song,
    onStationSelect: (Song) -> Unit
) {
    Card(
        elevation = 16.dp,
        modifier = Modifier
            .size(150.dp)
            .clickable {
                onStationSelect(station)
            }
    ) {
        Image(
            painter = rememberImagePainter(
                data = station.logoUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null
        )
    }

}