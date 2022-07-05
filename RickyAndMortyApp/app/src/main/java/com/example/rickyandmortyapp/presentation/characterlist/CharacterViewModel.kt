package com.example.rickyandmortyapp.presentation.characterlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickyandmortyapp.domain.usecase.getcharacters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharacterListState())
    val state: State<CharacterListState> = _state

    init {
        getCharacters(event = CharacterListEvent.GetCharacterEvents)
    }

    private fun getCharacters(event: CharacterListEvent) {
        getCharactersUseCase().onEach { characterList ->
            when (event) {
                is CharacterListEvent.GetCharacterEvents -> {
                    _state.value = CharacterListState(characters = characterList.data?.results)
                }
            }

        }.launchIn(viewModelScope)
    }
}