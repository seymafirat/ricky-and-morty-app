package com.example.rickyandmortyapp.presentation.characterlist

import com.example.rickyandmortyapp.data.remote.dto.CharacterResponseDto

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<CharacterResponseDto>? = null,
    val error: String = ""
)