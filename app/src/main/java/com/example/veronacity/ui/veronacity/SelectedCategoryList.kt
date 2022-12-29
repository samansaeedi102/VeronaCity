package com.example.veronacity.ui.veronacity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.veronacity.datasource.Datasource
import com.example.veronacity.model.Place
import com.example.veronacity.model.Category
import com.example.veronacity.model.Genre
import com.example.veronacity.ui.theme.VeronaCityTheme

@Composable
fun SelectedCategoryList(
    places: List<Place>,
    onClick: (Place) -> Unit,
    genre: Genre?,
    modifier: Modifier = Modifier
) {
    var placesFiltered = places.filter { it.genre == genre }
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(placesFiltered, key = { place -> place.id }) { place ->
            PlacesItemRow(item = place, onItemClick = onClick)
        }
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun PlacesItemRow(
    item: Place,
    onItemClick: (Place) -> Unit,
    modifier: Modifier = Modifier) {
    Card(
        elevation = 5.dp,
        onClick = {onItemClick(item)}
    ) {
        Row(modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(item.image),
                contentDescription = null,
                modifier
                    .size(60.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = item.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedCategoryListPreview() {
    VeronaCityTheme() {
        SelectedCategoryList(
            places = Datasource.places,
            onClick = {},
            genre = Genre.Cafe
        )
    }
}