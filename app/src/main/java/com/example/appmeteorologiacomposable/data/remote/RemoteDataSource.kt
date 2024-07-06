package com.example.appmeteorologiacomposable.data.remote

import WeatherDataResponse

interface RemoteDataSource {

    suspend fun getWeatherDataResponse(lat: Float, lng: Float) : WeatherDataResponse
}