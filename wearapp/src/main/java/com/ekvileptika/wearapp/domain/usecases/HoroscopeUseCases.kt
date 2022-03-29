package com.ekvileptika.wearapp.domain.usecases

import com.ekvileptika.wearapp.domain.model.HoroscopeModel
import com.ekvileptika.wearapp.domain.repository.HoroscopeRepository
import com.ekvileptika.wearapp.utils.Resource
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
            emit(
                Resource.Error(
                message = ex.localizedMessage.toString(),
                data = HoroscopeModel()
            ))
        }
    }
}