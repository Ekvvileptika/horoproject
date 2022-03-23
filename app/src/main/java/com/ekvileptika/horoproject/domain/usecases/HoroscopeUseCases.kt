package com.ekvileptika.horoproject.domain.usecases

import com.ekvileptika.horoproject.domain.model.HoroscopeModel
import com.ekvileptika.horoproject.domain.repository.HoroscopeRepository
import com.ekvileptika.horoproject.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class HoroscopeUseCases @Inject constructor(
    private val horoscopeRepo: HoroscopeRepository
){
    operator fun invoke(
        signname: String
    ): Flow<Resource<HoroscopeModel>> = flow{
        try {
            emit(Resource.Loading(data = HoroscopeModel()))
            val result = horoscopeRepo.getHoroscopeInformation(signname).toHoroscopeModel()
            emit(Resource.Success(result))
        } catch (ex: Exception){
            emit(Resource.Error(
                message = ex.localizedMessage.toString(),
                data = HoroscopeModel()
            ))
        }
    }
}