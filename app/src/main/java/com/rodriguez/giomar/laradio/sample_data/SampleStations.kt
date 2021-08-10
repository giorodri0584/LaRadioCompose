package com.rodriguez.giomar.laradio.sample_data

import com.rodriguez.giomar.laradio.model.Station

object SampleStations {
    fun fetchAllStations(): List<Station> {
        val stations = mutableListOf<Station>()
        stations.add(
            Station(
                logUrl = "https://firebasestorage.googleapis.com/v0/b/elmeneoapp-e7c12.appspot.com/o/stations%2Fla-bakana-santo-domingo.png?alt=media&token=6142eddf-ea76-455e-a10e-e28674a23f22"
            )
        )
        stations.add(
            Station(
                logUrl = "https://firebasestorage.googleapis.com/v0/b/elmeneoapp-e7c12.appspot.com/o/stations%2Fdisco%2088.9.png?alt=media&token=04b29052-0434-4d3c-8647-240228ae33c6"
            )
        )
        stations.add(
            Station(
                logUrl = "https://firebasestorage.googleapis.com/v0/b/elmeneoapp-e7c12.appspot.com/o/stations%2FMonumental.png?alt=media&token=bbdecd97-3d1f-41ac-a8e5-cf5390f1b195"
            )
        )
        stations.add(
            Station(
                logUrl = "https://firebasestorage.googleapis.com/v0/b/elmeneoapp-e7c12.appspot.com/o/stations%2Fla-bakana-santiago.png?alt=media&token=d0b1f0f6-f05a-432b-9793-66afc58d4776"
            )
        )

        return stations
    }
}