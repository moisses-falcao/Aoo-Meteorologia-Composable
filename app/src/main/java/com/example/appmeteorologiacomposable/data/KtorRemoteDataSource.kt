package com.example.appmeteorologiacomposable.data

import WeatherDataResponse
import com.example.appmeteorologiacomposable.data.remote.RemoteDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject


class KtorRemoteDataSource @Inject constructor(private val httpClient: HttpClient): RemoteDataSource {

    override suspend fun getWeatherDataResponse(lat: Float, lng: Float): WeatherDataResponse {
        return httpClient.get("${BASE_URL}//weather?lat=$lat&lon=$lng&appid=${API_KEY}&units=metric").body()
    }

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/data/2.5"
        private const val API_KEY = "59b7f3acadfc669a3bb940d0f6c41b98"
    }
}