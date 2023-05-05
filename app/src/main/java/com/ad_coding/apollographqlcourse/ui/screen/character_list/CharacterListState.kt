package com.ad_coding.apollographqlcourse.ui.screen.character_list

import com.ad_coding.apollographqlcourse.domain.model.SimpleCharacter

data class CharacterListState(
    val isLoading: Boolean = false,
    val characterList: List<SimpleCharacter> = emptyList()
)
