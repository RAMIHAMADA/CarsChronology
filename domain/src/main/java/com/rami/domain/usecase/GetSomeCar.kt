package com.rami.domain.usecase

import com.rami.domain.models.Car
import com.rami.domain.repository.SomeCarRepository
import javax.inject.Inject

class GetSomeCar @Inject constructor(
    private val someCarRepository: SomeCarRepository,
) {
    suspend fun getCar(id: Long): Car = someCarRepository.getSomeCar(id)
}
