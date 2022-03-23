package com.ekvileptika.horoproject.presentation.mainpage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekvileptika.horoproject.domain.model.HoroscopeModel
import com.ekvileptika.horoproject.domain.usecases.HoroscopeUseCases
import com.ekvileptika.horoproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    val useCases: HoroscopeUseCases
): ViewModel() {
    private val _horoState = mutableStateOf(HoroscopeModel())
    val horoState: State<HoroscopeModel> = _horoState

    private val _signList = mutableStateOf(SignData.signList)
    val signList: State<List<HoroscopeSignModel>> = _signList

    fun getHoroscopeInformation(signName: String){
        useCases(signName.lowercase()).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _horoState.value = result.data!!
                }

                is Resource.Loading -> {

                }

                is Resource.Error -> {

                }
            }
        }.launchIn(viewModelScope)
    }
}