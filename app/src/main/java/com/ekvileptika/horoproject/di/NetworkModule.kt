package com.ekvileptika.horoproject.di

import com.ekvileptika.horoproject.BuildConfig
import com.ekvileptika.horoproject.data.remote.HoroscopeApi
import com.ekvileptika.horoproject.data.remote.repository.HoroscopeRepositoryImpl
import com.ekvileptika.horoproject.domain.repository.HoroscopeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRequest(): HoroscopeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.API_URL)
            .build()
            .create(HoroscopeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(
        apiHoroscope: HoroscopeApi
    ): HoroscopeRepository{
        return HoroscopeRepositoryImpl(api = apiHoroscope)
    }
}