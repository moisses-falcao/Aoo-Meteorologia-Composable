package com.example.appmeteorologiacomposable.data.repository

import com.example.appmeteorologiacomposable.data.model.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Float, lng: Float) : WeatherInfo
}