package com.example.rickyandmortyapp.data.repository

import com.example.rickyandmortyapp.data.remote.api.RickyAndMortyApi
import com.example.rickyandmortyapp.data.remote.dto.CharacterListResponseDto
import com.example.rickyandmortyapp.domain.repository.ListRepository
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val rickyAndMortyApi: RickyAndMortyApi,
) : ListRepository {

    override suspend fun getCharacters(): CharacterListResponseDto {
        return rickyAndMortyApi.getCharacters()
    }
}