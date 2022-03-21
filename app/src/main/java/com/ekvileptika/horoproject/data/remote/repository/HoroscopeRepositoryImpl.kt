package com.ekvileptika.horoproject.data.remote.repository

import com.ekvileptika.horoproject.data.remote.HoroscopeApi
import com.ekvileptika.horoproject.data.remote.dto.HoroscopeRemoteDto
import com.ekvileptika.horoproject.domain.repository.HoroscopeRepository
import javax.inject.Inject

class HoroscopeRepositoryImpl @Inject constructor(
    private val api: HoroscopeApi
): HoroscopeRepository {
    override suspend fun getHoroscopeInformation(): HoroscopeRemoteDto {
        return api.getHoroscopeInformation()
    }
}