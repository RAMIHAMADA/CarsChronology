package com.rami.domain.usecase

import com.rami.domain.models.CarForList
import com.rami.domain.repository.ListOfCarsRepository
import javax.inject.Inject

class GetListCar @Inject constructor(
    private val listOfCarsRepository: ListOfCarsRepository,
) {
    suspend fun getListOfCar(page: Int): List<CarForList> = listOfCarsRepository.getListOfCar(page)
}
