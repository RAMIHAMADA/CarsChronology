package com.rami.domain.repository

import com.rami.domain.models.Car

interface SomeCarRepository {
    suspend fun getSomeCar(id: Long): Car
}
