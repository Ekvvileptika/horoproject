package com.ekvileptika.horoproject.domain.repository

import com.ekvileptika.horoproject.data.remote.dto.HoroscopeRemoteDto

interface HoroscopeRepository {
    suspend fun getHoroscopeInformation(): HoroscopeRemoteDto
}