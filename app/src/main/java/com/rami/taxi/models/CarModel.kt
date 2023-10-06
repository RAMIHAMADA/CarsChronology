package com.rami.taxi.models

data class CarModel(
    val id: Long = 0L,
    val name: String = "",
    val listUrl: List<String> = emptyList(),
)
