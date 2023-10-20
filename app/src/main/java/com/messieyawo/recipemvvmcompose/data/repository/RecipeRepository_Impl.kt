package com.messieyawo.recipemvvmcompose.data.repository

import com.messieyawo.recipemvvmcompose.data.network.api.ApiInterface
import com.messieyawo.recipemvvmcompose.data.network.model.search.RecipeResponse
import com.messieyawo.recipemvvmcompose.data.network.model.single.SingleFoodResponse


class RecipeRepository_Impl (
        private val apiInterface: ApiInterface
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): RecipeResponse {
        return apiInterface.search(token = token, page = page, query = query)
    }

    override suspend fun get(token: String, id: Int): SingleFoodResponse {
        return apiInterface.get(token = token, id)
    }

}