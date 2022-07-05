package com.example.rickyandmortyapp.di

import com.example.rickyandmortyapp.data.remote.api.RickyAndMortyApi
import com.example.rickyandmortyapp.data.repository.ListRepositoryImpl
import com.example.rickyandmortyapp.domain.repository.ListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickyAndMortyApi(): RickyAndMortyApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(interceptorRickyAndMortyApi())
            .build()
            .create(RickyAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideListRepository(api: RickyAndMortyApi): ListRepository {
        return ListRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun interceptorRickyAndMortyApi(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .addInterceptor(NetworkInterceptor())
        return builder.build()
    }
}