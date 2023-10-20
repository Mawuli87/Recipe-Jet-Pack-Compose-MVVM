package com.messieyawo.recipemvvmcompose.data.network.model.search


import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val recipes: List<Recipe?>?
)