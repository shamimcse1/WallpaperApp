package com.codercamp.wallpaperapp.di

import com.codercamp.wallpaperapp.common.Constants
import com.codercamp.wallpaperapp.data.remote.Api
import com.codercamp.wallpaperapp.data.repository.ImageRepositoryImpl
import com.codercamp.wallpaperapp.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideImageListApi(): Api {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideImageListRepository(api: Api): ImageRepository {
        return ImageRepositoryImpl(api)
    }
}