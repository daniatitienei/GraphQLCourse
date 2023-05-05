package com.ad_coding.apollographqlcourse.ui.screen.character_list

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
class CharacterListViewModel @Inject constructor(
    private val useCases: CharacterUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterListState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
        viewModelScope.launch {
            val result = useCases.getCharacterList.execute()

            _state.update {
                it.copy(
                    isLoading = false,
                    characterList = result
                )
            }
        }
    }
}