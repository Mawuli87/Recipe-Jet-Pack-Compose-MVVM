package com.messieyawo.recipemvvmcompose.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.messieyawo.recipemvvmcompose.data.network.model.search.Recipe
import com.messieyawo.recipemvvmcompose.presentation.ui.recipe_list.PAGE_SIZE
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun RecipeList(
    loading: Boolean,
    recipes: List<Recipe?>?,
    onChangeScrollPosition: (Int) -> Unit,
    page: Int,
    onTriggerNextPage: () -> Unit,
    onNavigateToRecipeDetailScreen: (Int) -> Unit,
){
    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {
        if (recipes != null) {
            if (loading && recipes.isEmpty()) {
                //HorizontalDottedProgressBar()
                LoadingRecipeListShimmer(imageHeight = 250.dp,)
            }
            else if(recipes.isEmpty()){
                NothingHere()
            }
            else {
                LazyColumn{
                    itemsIndexed(
                        items = recipes
                    ) { index, recipe ->

                        //scroll position and index
                        onChangeScrollPosition(index)

                        if ((index + 1) >= (page * PAGE_SIZE) && !loading) {
                            onTriggerNextPage()
                        }
                        if (recipe != null) {
                            RecipeCard(
                                recipe = recipe,
                                onClick = {
                                    recipe.pk?.let { onNavigateToRecipeDetailScreen(it) }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}







