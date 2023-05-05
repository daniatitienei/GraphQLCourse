package com.ad_coding.apollographqlcourse.ui.screen.character_detail

import com.ad_coding.apollographqlcourse.domain.model.Character

data class CharacterState(
    val isLoading: Boolean = false,
    val character: Character? = null
)
