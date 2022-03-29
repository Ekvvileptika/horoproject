package com.ekvileptika.wearapp.di


import com.ekvileptika.wearapp.BuildConfig
import com.ekvileptika.wearapp.data.remote.HoroscopeApi
import com.ekvileptika.wearapp.data.remote.repository.HoroscopeRepositoryImpl
import com.ekvileptika.wearapp.domain.repository.HoroscopeRepository
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
    ): HoroscopeRepository {
        return HoroscopeRepositoryImpl(api = apiHoroscope)
    }

/*    @Singleton
    @Provides
    fun provideUseCase(
        repo: HoroscopeRepository
    ): HoroscopeUseCases {
        return HoroscopeUseCases(repo)
    }*/
}