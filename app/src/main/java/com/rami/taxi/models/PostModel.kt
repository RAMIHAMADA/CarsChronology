package com.rami.taxi.models

data class PostModel(
    val id: Long = 0L,
    val text: String = "",
    val author: User,
    val date: String = "",
    val likeCount: Long = 0L,
    val commentCount: Long = 0L,
    val image: String = "",
)

data class User(
    val id: Long,
    val username: String,
    val avatar: Avatar,
)

data class Avatar(
    val url: String,
)
