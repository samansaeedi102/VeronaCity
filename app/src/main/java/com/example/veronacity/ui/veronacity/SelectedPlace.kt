package com.example.veronacity.ui.veronacity

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.veronacity.datasource.Datasource
import com.example.veronacity.model.Place
import com.example.veronacity.ui.theme.VeronaCityTheme

@Composable
fun SelectedPlaceDetails(
    selectedPlace: Place,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler() {
        onBackPressed
    }
    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxHeight()
    ) {
        SelectedPlaceDetailsImage(placeInstance = selectedPlace)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = selectedPlace.name,
        style = MaterialTheme.typography.h3)
        Text(text = selectedPlace.description,
        style = MaterialTheme.typography.body1)
    }
}
@Composable
private fun SelectedPlaceDetailsImage(placeInstance: Place,
modifier: Modifier = Modifier) {
    Box(modifier = modifier.height(280.dp)) {
        Image(
            painter = painterResource(placeInstance.image),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(5.dp))
            )
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedPlaceDetailsPreview() {
    VeronaCityTheme() {
        SelectedPlaceDetails(selectedPlace = Datasource.places[0], onBackPressed = {  })
    }
}