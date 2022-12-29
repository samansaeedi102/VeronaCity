package com.example.veronacity.ui.veronacity

import com.example.veronacity.datasource.Datasource.places
import com.example.veronacity.model.Category
import com.example.veronacity.model.Genre
import com.example.veronacity.model.Place

data class UiState(
    val categories: List<Place> = emptyList(),
    val currentGenre: Genre? = null,
    val currentSelectedPlace: Place = places[0]
)