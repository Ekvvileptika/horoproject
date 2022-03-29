package com.ekvileptika.wearapp.domain.repository

import com.ekvileptika.wearapp.data.remote.dto.HoroscopeRemoteDto

interface HoroscopeRepository {
    suspend fun getHoroscopeInformation(
        signName: String
    ): HoroscopeRemoteDto
}