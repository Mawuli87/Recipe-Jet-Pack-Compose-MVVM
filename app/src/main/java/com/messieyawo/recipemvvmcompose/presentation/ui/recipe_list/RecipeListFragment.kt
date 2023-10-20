package com.messieyawo.recipemvvmcompose.presentation.ui.recipe_list

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.messieyawo.recipemvvmcompose.BaseApplication
import com.messieyawo.recipemvvmcompose.R
import com.messieyawo.recipemvvmcompose.presentation.components.RecipeList
import com.messieyawo.recipemvvmcompose.presentation.components.SearchAppBar
import com.messieyawo.recipemvvmcompose.presentation.components.SnackbarController
import com.messieyawo.recipemvvmcompose.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.messieyawo.recipemvvmcompose.presentation.ui.recipe_list.RecipeListEvent.NewSearchEvent
import com.messieyawo.recipemvvmcompose.presentation.ui.recipe_list.RecipeListEvent.RestoreStateEvent
import com.messieyawo.recipemvvmcompose.presentation.ui.recipe_list.RecipeListEvent.NextPageEvent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class,
ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication
    private val viewModel: RecipeListViewModel by viewModels()

    private val snackbarController = SnackbarController(lifecycleScope)


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
          return ComposeView(requireContext()).apply {
            setContent {

                val recipes = viewModel.recipes.value

                val query = viewModel.query.value

                val selectedCategory = viewModel.selectedCategory.value

                val loading = viewModel.loading.value

               val page = viewModel.page.value

                val scaffoldState = rememberScaffoldState()



                AppTheme(
                    displayProgressBar = loading,
                    scaffoldState = scaffoldState,
                    darkTheme = application.isDark.value,
                ) {

                    Scaffold(
                        topBar = {
                            SearchAppBar(
                                query = query,
                                onQueryChanged = viewModel::onQueryChanged,
                                onExecuteSearch = {
                                    if (viewModel.selectedCategory.value?.value == "Milk") {
                                        snackbarController.getScope().launch {
                                            snackbarController.showSnackbar(
                                                scaffoldState = scaffoldState,
                                                message = "Invalid category: MILK",
                                                actionLabel = "Hide"
                                            )
                                        }
                                    } else {
                                        viewModel.onTriggerEvent(NewSearchEvent)
                                    }
                                },
                                categories = getAllFoodCategories(),
                                selectedCategory = selectedCategory,
                                onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                                onToggleTheme = application::toggleLightTheme
                            )
                        },
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        },

                        ) {

                        RecipeList(

                            loading = loading,
                            recipes = recipes,
                            onChangeScrollPosition = viewModel::onChangeRecipeScrollPosition,
                            page = page,
                            onTriggerNextPage = { viewModel.onTriggerEvent(NextPageEvent) },
                            onNavigateToRecipeDetailScreen = {
                                val bundle = Bundle()
                                bundle.putInt("recipeId", it)
                                findNavController().navigate(R.id.action_recipeListFragment_to_recipeFragment, bundle)
                            }
                        )
                    }
                }



            }}
    }


}