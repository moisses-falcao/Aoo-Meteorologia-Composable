package com.example.appmeteorologiacomposable.ui.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmeteorologiacomposable.data.model.WeatherInfo
import com.example.appmeteorologiacomposable.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor( private val repository: WeatherRepository) : ViewModel() {

    private val _weatherInfoState = MutableStateFlow(WeatherInfoState())
    val weatherInfoState : StateFlow<WeatherInfoState> = _weatherInfoState.asStateFlow()

    init{
        getWeatherInfo()
    }

    private fun getWeatherInfo() {
        viewModelScope.launch {
            val weatherInfo = repository.getWeatherData(-23.5489f, -46.6388f)
            _weatherInfoState.update {
                it.copy(weatherInfo = weatherInfo)
            }
        }
    }
}

data class WeatherInfoState(
    val weatherInfo: WeatherInfo? = null
)