package com.rami.taxi.ui.main_screen

import com.rami.taxi.models.CarForListModel

data class CarListState(
    val isLoaded: Boolean = false,
    val listCars: List<CarForListModel> = emptyList(),
    val page: Int = 1,
)
