package com.example.rickyandmortyapp.domain.model

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("status")
    val status: String?,
)