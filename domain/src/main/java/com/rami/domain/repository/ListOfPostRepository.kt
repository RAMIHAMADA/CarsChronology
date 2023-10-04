package com.rami.domain.repository

import com.rami.domain.models.Post

interface ListOfPostRepository {
    suspend fun getListOfPost(id: Long): List<Post>
}
