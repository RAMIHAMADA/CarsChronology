package com.rami.data.repository

import com.rami.data.retrofit.ApiService
import com.rami.domain.models.CarForList
import com.rami.domain.repository.ListOfCarsRepository
import retrofit2.awaitResponse
import javax.inject.Inject

class ListOfCarsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    ListOfCarsRepository {
    override suspend fun getListOfCar(page: Int): List<CarForList> {
        val response = apiService.getListCars(page).awaitResponse()
        return if (response.isSuccessful && response.body() !== null) {
            response.body()!!.map {
                CarForList(
                    id = it.id,
                    name = it.name,
                    urlPhoto = it.image,
                )
            }
        } else {
            emptyList()
        }
    }
}
