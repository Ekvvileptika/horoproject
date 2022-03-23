package com.ekvileptika.horoproject.presentation.mainpage

import androidx.annotation.DrawableRes
import com.ekvileptika.horoproject.R

data class HoroscopeSignModel(
    val id: Int,
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

object SignData{
    val signList = listOf(
        HoroscopeSignModel(1, "Aries", "Description", R.drawable.aries),
        HoroscopeSignModel(2, "Taurus", "Description", R.drawable.taurus),
        HoroscopeSignModel(3, "Gemini", "Description", R.drawable.gemini),
        HoroscopeSignModel(4, "Cancer", "Description", R.drawable.cancer),
        HoroscopeSignModel(5, "Leo", "Description", R.drawable.leo),
        HoroscopeSignModel(6, "Virgo", "Description", R.drawable.virgo),
        HoroscopeSignModel(7, "Libra", "Description", R.drawable.libra),
        HoroscopeSignModel(8, "Scorpio", "Description", R.drawable.scorpio),
        HoroscopeSignModel(9, "Sagittarius", "Description", R.drawable.sagitiarius),
        HoroscopeSignModel(10, "Capricorn", "Description", R.drawable.capricorn),
        HoroscopeSignModel(11, "Aquarius", "Description", R.drawable.aquarius),
        HoroscopeSignModel(12, "Pisces", "Description", R.drawable.pisces)
    )
}