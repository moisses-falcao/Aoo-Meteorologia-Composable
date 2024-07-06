package com.example.appmeteorologiacomposable.data.di

import com.example.appmeteorologiacomposable.data.remote.RemoteDataSource
import com.example.appmeteorologiacomposable.data.repository.WeatherRepository
import com.example.appmeteorologiacomposable.data.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindWeatherRepository(repository: WeatherRepositoryImpl) : WeatherRepository
}