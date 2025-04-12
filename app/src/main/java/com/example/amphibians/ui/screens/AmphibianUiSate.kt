package com.example.amphibians.ui.screens

import com.example.amphibians.model.Amphibian

sealed interface AmphibianUiSate {
    data class Success(
        val amphibians: List<Amphibian>
    ) : AmphibianUiSate

    object Error : AmphibianUiSate

    object Loading: AmphibianUiSate
}