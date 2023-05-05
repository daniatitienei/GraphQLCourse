package com.ad_coding.apollographqlcourse.ui.screen.character_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ad_coding.apollographqlcourse.domain.use_case.CharacterUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val useCases: CharacterUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
        savedStateHandle.get<String>("id")?.let { id ->
            viewModelScope.launch {
                val result = useCases.getCharacterById.execute(id)
                _state.update {
                    it.copy(
                        isLoading = false,
                        character = result
                    )
                }
            }
        }
    }
}