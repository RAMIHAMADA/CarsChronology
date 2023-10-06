package com.rami.data.repository

import com.rami.data.retrofit.ApiService
import com.rami.domain.models.Car
import com.rami.domain.repository.SomeCarRepository
import retrofit2.awaitResponse
import javax.inject.Inject

class SomeCarRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    SomeCarRepository {
    override suspend fun getSomeCar(id: Long): Car {
        val response = apiService.getCar(id).awaitResponse()
        return if (response.isSuccessful && response.body() !== null) {
            val localCar = response.body()!!.car
            Car(
                id = localCar.id,
                name = localCar.name,
                listUrl = localCar.images.map { it.url },
            )
        } else {
            return Car(
                id = 0,
                name = "",
                listUrl = emptyList(),
            )
        }
    }
}
