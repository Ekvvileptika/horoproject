package com.ekvileptika.horoproject.data.remote.dto

import com.ekvileptika.horoproject.domain.model.HoroscopeModel

data class HoroscopeRemoteDto(
    val date_range: String?,
    val current_date: String?,
    val description: String?,
    val compatibility: String?,
    val mood: String?,
    val color: String?,
    val lucky_number: String?,
    val lucky_time: String?
){
    fun toHoroscopeModel(): HoroscopeModel {
        return HoroscopeModel(
            description = this.description ?: "", // if nothing comes from backand,
            date_range = this.date_range ?: "",
            color = this.color ?: ""
        )
    }
}