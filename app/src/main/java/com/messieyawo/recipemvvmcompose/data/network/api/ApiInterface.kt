package com.messieyawo.recipemvvmcompose.data.network.api

import com.messieyawo.recipemvvmcompose.data.network.model.search.RecipeResponse
import com.messieyawo.recipemvvmcompose.data.network.model.single.SingleFoodResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeResponse

    @GET("get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): SingleFoodResponse
}