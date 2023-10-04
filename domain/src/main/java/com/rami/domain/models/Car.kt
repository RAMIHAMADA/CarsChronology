package com.rami.domain.models

data class Car(
    val id: Long = 0L,
    val name: String = "",
    val listUrl: List<String> = emptyList(),
)
