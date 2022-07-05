package com.example.rickyandmortyapp.data.remote.api

import com.example.rickyandmortyapp.data.remote.dto.CharacterListResponseDto
import retrofit2.http.GET

interface RickyAndMortyApi {

    @GET("character")
    suspend fun getCharacters(): CharacterListResponseDto
}