package com.ekvileptika.wearapp.data.remote

import com.ekvileptika.wearapp.data.remote.dto.HoroscopeRemoteDto
import retrofit2.http.POST
import retrofit2.http.Query

interface HoroscopeApi {
    @POST("/")
    suspend fun getHoroscopeInformation(
        @Query("sign") signame: String,
        @Query("day") day: String = "today"
    ): HoroscopeRemoteDto
}