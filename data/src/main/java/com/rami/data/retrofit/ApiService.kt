package com.rami.data.retrofit

import com.rami.data.retrofit.models.CarDataResponse
import com.rami.data.retrofit.models.CarForListData
import com.rami.data.retrofit.models.PostDataResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("cars/list")
    fun getListCars(@Query("page") page: Int): retrofit2.Call<List<CarForListData>>

    @GET("car/{id}")
    fun getCar(@Path("id") carId: Long): retrofit2.Call<CarDataResponse>

    @GET("car/{id}/posts")
    fun getListPost(@Path("id") carId: Long): retrofit2.Call<PostDataResponse>
}

