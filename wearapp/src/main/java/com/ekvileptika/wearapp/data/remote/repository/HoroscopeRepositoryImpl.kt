package com.ekvileptika.wearapp.data.remote.repository

import com.ekvileptika.wearapp.data.remote.HoroscopeApi
import com.ekvileptika.wearapp.data.remote.dto.HoroscopeRemoteDto
import com.ekvileptika.wearapp.domain.repository.HoroscopeRepository
import javax.inject.Inject

class HoroscopeRepositoryImpl @Inject constructor(
    private val api: HoroscopeApi
): HoroscopeRepository {
    override suspend fun getHoroscopeInformation(signName: String): HoroscopeRemoteDto {
        return api.getHoroscopeInformation(signName)
    }
}