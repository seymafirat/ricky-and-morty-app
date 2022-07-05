package com.example.rickyandmortyapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterListResponseDto(
    @SerializedName("results")
    val results: List<CharacterResponseDto>?
)
