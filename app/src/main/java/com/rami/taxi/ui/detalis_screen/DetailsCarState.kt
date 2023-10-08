package com.rami.taxi.ui.detalis_screen

import com.rami.taxi.models.CarModel
import com.rami.taxi.models.PostModel

data class DetailsCarState(
    val isLoaded: Boolean = false,
    val listPosts: List<PostModel> = emptyList(),
    val someCar: CarModel = CarModel(
        id = 0,
        name = "",
        listUrl = emptyList(),
    ),
)
