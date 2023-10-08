package com.rami.taxi.di

import com.rami.data.repository.ListOfCarsRepositoryImpl
import com.rami.data.repository.ListOfPostRepositoryImpl
import com.rami.data.repository.SomeCarRepositoryImpl
import com.rami.domain.repository.ListOfCarsRepository
import com.rami.domain.repository.ListOfPostRepository
import com.rami.domain.repository.SomeCarRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModuleDependencies {

    @Binds
    fun bindListOfCarRepositoryToListOfCarsRepositoryImpl(listOfCarRepository: ListOfCarsRepositoryImpl): ListOfCarsRepository

    @Binds
    fun bindListOfPostsRepositoryToListOfPostsRepositoryImpl(listOfPostsRepository: ListOfPostRepositoryImpl): ListOfPostRepository

    @Binds
    fun bindSomeCarRepositoryToSomeCarRepositoryImpl(someCarRepository: SomeCarRepositoryImpl): SomeCarRepository
}
