package com.rami.domain.usecase

import com.rami.domain.models.Post
import com.rami.domain.repository.ListOfPostRepository
import javax.inject.Inject

class GetListOfPosts @Inject constructor(
    private val listOfPosts: ListOfPostRepository,
) {
    suspend fun getListOfPosts(id: Long): List<Post> = listOfPosts.getListOfPost(id)
}
