package com.rami.data.repository

import com.rami.data.retrofit.ApiService
import com.rami.domain.models.Avatar
import com.rami.domain.models.Post
import com.rami.domain.models.User
import com.rami.domain.repository.ListOfPostRepository
import retrofit2.awaitResponse
import javax.inject.Inject

class ListOfPostRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    ListOfPostRepository {
    override suspend fun getListOfPost(id: Long): List<Post> {
        val response = apiService.getListPost(id).awaitResponse()
        return if (response.isSuccessful && response.body() !== null) {
            response.body()!!.posts.map {
                Post(
                    id = it.id,
                    text = it.text,
                    author = User(
                        id = it.id,
                        username = it.author.username,
                        avatar = Avatar(url = it.author.avatar.url),
                    ),
                    date = it.createdAt,
                    likeCount = it.likeCount,
                    commentCount = it.commentCount,
                    image = it.img ?: "",
                )
            }
        } else {
            emptyList()
        }
    }
}
