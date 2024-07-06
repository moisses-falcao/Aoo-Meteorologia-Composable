package com.example.appmeteorologiacomposable.data.di

import com.example.appmeteorologiacomposable.data.KtorRemoteDataSource
import com.example.appmeteorologiacomposable.data.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindRemoteDataSource(ktorRemoteDataSource: KtorRemoteDataSource) : RemoteDataSource
}