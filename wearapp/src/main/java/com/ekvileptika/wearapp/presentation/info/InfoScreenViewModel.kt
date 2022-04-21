package com.ekvileptika.wearapp.presentation.info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekvileptika.wearapp.domain.model.HoroscopeModel
import com.ekvileptika.wearapp.domain.usecases.HoroscopeUseCases
import com.ekvileptika.wearapp.presentation.mainpage.HoroscopeSignModel
import com.ekvileptika.wearapp.presentation.mainpage.SignData
import com.ekvileptika.wearapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class InfoScreenViewModel @Inject constructor(
    val useCases: HoroscopeUseCases
): ViewModel() {
    val horoState = mutableStateOf<Resource<HoroscopeModel>>(Resource.Loading())

    fun getHoroscopeInformation(signName: String){
        useCases(signName.lowercase()).onEach { result ->
            when(result){
                is Resource.Success -> {
                    horoState.value = Resource.Success(result.data!!)
                }

                is Resource.Loading -> {
                    horoState.value = Resource.Loading()
                }

                is Resource.Error -> {
                    horoState.value = Resource.Error(message = result.message ?: "Error!")
                }
            }
        }.launchIn(viewModelScope)
    }
}