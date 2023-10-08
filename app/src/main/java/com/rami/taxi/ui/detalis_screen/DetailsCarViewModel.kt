package com.rami.taxi.ui.detalis_screen

import androidx.lifecycle.viewModelScope
import com.rami.domain.usecase.GetListOfPosts
import com.rami.domain.usecase.GetSomeCar
import com.rami.taxi.base.BaseViewModel
import com.rami.taxi.models.Avatar
import com.rami.taxi.models.CarModel
import com.rami.taxi.models.PostModel
import com.rami.taxi.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsCarViewModel @Inject constructor(
    private val getListOfPosts: GetListOfPosts,
    private val getSomeCar: GetSomeCar,
) : BaseViewModel<DetailsCarState>(DetailsCarState()) {

    fun updateState(id: Long) {
        isNotLoaded()
        viewModelScope.launch(Dispatchers.IO) {
            val getSomeCarDeferred = async { getSomeCar.getCar(id) }
            val getListOfPostsDeferred = async { getListOfPosts.getListOfPosts(id) }

            val getSomeCarResult = getSomeCarDeferred.await()
            val listOfPosts = getListOfPostsDeferred.await()

            updateState {
                it.copy(
                    someCar = CarModel(
                        id = getSomeCarResult.id,
                        name = getSomeCarResult.name,
                        listUrl = getSomeCarResult.listUrl,
                    ),
                    listPosts = listOfPosts.map { post ->
                        PostModel(
                            id = post.id,
                            text = post.text,
                            author = User(
                                id = post.author.id,
                                username = post.author.username,
                                avatar = Avatar(post.author.avatar.url),
                            ),
                            date = post.date,
                            likeCount = post.likeCount,
                            commentCount = post.commentCount,
                            image = post.image,
                        )
                    },
                    isLoaded = true,
                )
            }
        }
    }

    private fun isNotLoaded() {
        updateState {
            it.copy(
                isLoaded = false,
            )
        }
    }
}
