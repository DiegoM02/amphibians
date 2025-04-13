package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibianApplication
import com.example.amphibians.data.AmphibianRepository
import kotlinx.coroutines.launch
import okio.IOException

class AmphibianViewModel(
    private val amphibianRepository: AmphibianRepository
): ViewModel() {

    var amphibianUiState: AmphibianUiSate by mutableStateOf(AmphibianUiSate.Loading)
        private set

    init {
        getAmphibians()
    }


    fun getAmphibians() = viewModelScope.launch{
        amphibianUiState = try {
            AmphibianUiSate.Success(amphibianRepository.getAmphibians())
        } catch (e: IOException){
            AmphibianUiSate.Error
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianApplication)
                val amphibianRepository = application.appContainer.amphibianRepository
                AmphibianViewModel(amphibianRepository = amphibianRepository)
            }
        }
    }


}