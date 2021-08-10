package com.rodriguez.giomar.laradio.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodriguez.giomar.laradio.model.Station
import com.rodriguez.giomar.laradio.sample_data.SampleStations
import com.rodriguez.giomar.laradio.station_list_screen.StationListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.StationListScreen.route) {
        composable(Screen.StationListScreen.route) {
            val stations: List<Station> = remember {
                SampleStations.fetchAllStations()
            }
            StationListScreen(stations) {
                navController.navigate(Screen.StationDetailsScreen.route)
            }
        }
        composable(Screen.StationDetailsScreen.route) {
            Text(text = "Station Details Screen")
        }
    }
}