package com.rodriguez.giomar.laradio.navigation

sealed class Screen (val route: String) {
    object StationListScreen: Screen("station_list")
    object StationDetailsScreen: Screen("station_details")
}
