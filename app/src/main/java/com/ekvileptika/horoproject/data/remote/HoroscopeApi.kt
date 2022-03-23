package com.ekvileptika.horoproject.data.remote

import com.ekvileptika.horoproject.data.remote.dto.HoroscopeRemoteDto
import retrofit2.http.POST
import retrofit2.http.Query

interface HoroscopeApi {
    @POST("/")
    suspend fun getHoroscopeInformation(
        @Query("sign") signame: String,
        @Query("day") day: String = "today"
    ): HoroscopeRemoteDto
}