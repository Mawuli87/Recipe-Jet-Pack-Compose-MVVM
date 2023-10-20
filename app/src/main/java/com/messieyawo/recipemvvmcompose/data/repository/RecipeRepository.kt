package com.messieyawo.recipemvvmcompose.data.repository

import com.messieyawo.recipemvvmcompose.data.network.model.search.RecipeResponse
import com.messieyawo.recipemvvmcompose.data.network.model.single.SingleFoodResponse


interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): RecipeResponse

    suspend fun get(token: String, id: Int): SingleFoodResponse

}
