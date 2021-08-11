package com.rodriguez.giomar.laradio.presentation.station_list_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.rodriguez.giomar.laradio.data.entities.Song
import com.rodriguez.giomar.laradio.model.Station

@Composable
fun StationCityList(
    stations: List<Song>,
    onStationSelect: (Song) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(stations) { station ->
            StationCard(station = station) { station ->
                onStationSelect(station)
            }
        }

    }
}