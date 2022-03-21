package com.ekvileptika.horoproject.data.remote

import com.ekvileptika.horoproject.data.remote.dto.HoroscopeRemoteDto
import retrofit2.http.POST

interface HoroscopeApi {
    @POST("/?sign=aries&day=yesterday")
    suspend fun getHoroscopeInformation(): HoroscopeRemoteDto
}