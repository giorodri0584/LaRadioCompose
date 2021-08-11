package com.rodriguez.giomar.laradio.navigation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodriguez.giomar.laradio.data.entities.Song
import com.rodriguez.giomar.laradio.model.Station
import com.rodriguez.giomar.laradio.other.Resource
import com.rodriguez.giomar.laradio.other.Status
import com.rodriguez.giomar.laradio.presentation.station_list_screen.LoadingScreen
import com.rodriguez.giomar.laradio.sample_data.SampleStations
import com.rodriguez.giomar.laradio.presentation.station_list_screen.StationListScreen
import com.rodriguez.giomar.laradio.presentation.station_list_screen.StationListScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.StationListScreen.route) {
        composable(Screen.StationListScreen.route) {
            val viewModel = hiltViewModel<StationListScreenViewModel>()
            val mediaItems = viewModel.mediaItems.value
            val currentSong = viewModel.currentPlayingSong.observeAsState()
            when(mediaItems.status) {
                Status.SUCCESS -> {
                    mediaItems.data?.let { songs ->
                        StationListScreen(stations = songs, currentSong = currentSong.value) { song ->
                            viewModel.playOrToggleSong(song)
                        }
                    }

                }
                Status.ERROR -> {

                }
                Status.LOADING -> {
                    LoadingScreen()
                }
            }
        }
        composable(Screen.StationDetailsScreen.route) {
            Text(text = "Station Details Screen")
        }
    }
}