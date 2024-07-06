package com.example.appmeteorologiacomposable.data.repository

import com.example.appmeteorologiacomposable.data.model.WeatherInfo
import com.example.appmeteorologiacomposable.data.remote.RemoteDataSource
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    WeatherRepository {

    override suspend fun getWeatherData(lat: Float, lng: Float): WeatherInfo {
        val response = remoteDataSource.getWeatherDataResponse(lat, lng)
        val weather = response.weather[0]

        response.apply {
            return WeatherInfo(
                locationName = name,
                conditionIcon = weather.icon,
                condition = weather.main,
                temperature = main.temp.roundToInt(),
                dayOfWeek = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()),
                isDay = weather.icon.last() == 'd'
            )
        }
    }
}