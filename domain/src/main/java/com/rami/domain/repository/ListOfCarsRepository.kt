package com.rami.domain.repository

import com.rami.domain.models.CarForList

interface ListOfCarsRepository {
    suspend fun getListOfCar(page: Int): List<CarForList>
}
