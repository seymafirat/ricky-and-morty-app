package com.example.rickyandmortyapp.domain.usecase.getcharacters

import com.example.rickyandmortyapp.common.Resource
import com.example.rickyandmortyapp.data.remote.dto.CharacterListResponseDto
import com.example.rickyandmortyapp.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val listRepository: ListRepository,
) {
    operator fun invoke(): Flow<Resource<CharacterListResponseDto>> = flow {
        try {
            emit(Resource.Loading<CharacterListResponseDto>())
            val characters = listRepository.getCharacters()
            emit(Resource.Success<CharacterListResponseDto>(characters))
        } catch (e: HttpException) {
            emit(
                Resource.Error<CharacterListResponseDto>(
                    e.localizedMessage ?: "An unexpected error"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<CharacterListResponseDto>("Check your internet connection"))
        }
    }
}