package com.rodriguez.giomar.laradio.station_list_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rodriguez.giomar.laradio.model.Station

@Composable
fun StationListScreen(
    stations: List<Station>,
    onStationSelect: (Station) -> Unit
) {
    LazyColumn() {
        items(2) {
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
}