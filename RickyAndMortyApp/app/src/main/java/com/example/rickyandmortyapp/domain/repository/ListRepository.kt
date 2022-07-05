package com.example.rickyandmortyapp.domain.repository

import com.example.rickyandmortyapp.data.remote.dto.CharacterListResponseDto

interface ListRepository {

    suspend fun getCharacters(): CharacterListResponseDto
}