package com.example.appmeteorologiacomposable.ui.feature

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.appmeteorologiacomposable.data.model.WeatherInfo
import com.example.appmeteorologiacomposable.ui.theme.AppMeteorologiaComposableTheme
import com.example.appmeteorologiacomposable.ui.theme.BlueSky
import com.example.appmeteorologiacomposable.ui.theme.DarkBlueSky
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherRoute(viewModel : WeatherViewModel = viewModel()) {
    val weatherInfoState by viewModel.weatherInfoState.collectAsStateWithLifecycle()
    WeatherScreen(weatherInfo = weatherInfoState.weatherInfo)
}

@Composable
fun WeatherScreen(context: Context = LocalContext.current, weatherInfo: WeatherInfo?) {
    weatherInfo?.let {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = if (weatherInfo.isDay) BlueSky else DarkBlueSky,
            contentColor = Color.White,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = weatherInfo.locationName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = weatherInfo.dayOfWeek,
                    fontSize = 18.sp,
                )
                Spacer(modifier = Modifier.size(50.dp))

                val iconDrawable: Int = context.resources.getIdentifier(
                    "weather_${weatherInfo.conditionIcon}",
                    "drawable",
                    context.packageName,
                )

                Image(
                    painter = painterResource(id = iconDrawable),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.size(25.dp))
                Text(
                    text = weatherInfo.condition,
                    fontSize = 18.sp,
                )
                Spacer(modifier = Modifier.size(50.dp))
                Text(
                    text = weatherInfo.temperature.toString() + "°",
                    fontWeight = FontWeight.Thin,
                    fontSize = 100.sp,
                )
            }
        }
    }
}

@Preview
@Composable
private fun WeatherScreenPreview() {
    AppMeteorologiaComposableTheme {
        WeatherScreen(
            weatherInfo = WeatherInfo(
                locationName = "São Paulo",
                conditionIcon = "01d",
                condition = "Sunny",
                temperature = 20,
                dayOfWeek = "Sunday",
                isDay = true
            )
        )
    }
}