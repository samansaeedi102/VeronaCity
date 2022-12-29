package com.example.veronacity.ui.veronacity

import androidx.lifecycle.ViewModel
import com.example.veronacity.datasource.Datasource
import com.example.veronacity.datasource.Datasource.places
import com.example.veronacity.model.Category
import com.example.veronacity.model.Genre
import com.example.veronacity.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModel: ViewModel() {


    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun updateCurrentGenre(selectedGenre: Genre) {
        _uiState.update { currentState ->
            currentState.copy(currentGenre = selectedGenre)
        }
    }
    fun updateCurrentSelectedPlace(selectedPlace: Place) {
        _uiState.update { currentState ->
            currentState.copy(currentSelectedPlace = selectedPlace)
        }
    }

}