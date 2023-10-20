package com.messieyawo.recipemvvmcompose.data.di


import com.messieyawo.recipemvvmcompose.data.network.api.ApiInterface
import com.messieyawo.recipemvvmcompose.data.repository.RecipeRepository
import com.messieyawo.recipemvvmcompose.data.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
            apiInterface: ApiInterface
    ): RecipeRepository {
        return RecipeRepository_Impl(
            apiInterface = apiInterface
        )
    }
}

