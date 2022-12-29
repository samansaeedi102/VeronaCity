package com.example.veronacity.ui.veronacity


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.veronacity.datasource.Datasource.categories
import com.example.veronacity.datasource.Datasource.places
import com.example.veronacity.model.Category
import com.example.veronacity.model.Genre
import com.example.veronacity.ui.theme.VeronaCityTheme

private const val TAG = "StateChange"
enum class Screen( val title: String) {
    ChooseCategory(title = "Start Tour"),
    ChoosePlace(title = "Choose Place"),
    ObservePlace(title = "Details")
}

@Composable
fun AppBar(
    currentScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = currentScreen.title)},
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        }
    )
}

@Composable
fun App(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screen.valueOf(
        backStackEntry?.destination?.route ?: Screen.ChooseCategory.name
    )

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp()})
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(navController = navController,
            startDestination = Screen.ChooseCategory.name,
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable(route = Screen.ChooseCategory.name) {
                Screen(
                    categories = categories,
                    onClick = {
                        navController.navigate(Screen.ChoosePlace.name)
                        viewModel.updateCurrentGenre(selectedGenre = it)
                    } )
            }
            composable(route = Screen.ChoosePlace.name) {
                SelectedCategoryList(places = places,
                    onClick = {
                        navController.navigate(Screen.ObservePlace.name)
                        viewModel.updateCurrentSelectedPlace(it)
                    },
                    genre = uiState.currentGenre )
            }
            composable(route = Screen.ObservePlace.name) {
                SelectedPlaceDetails(selectedPlace = uiState.currentSelectedPlace, onBackPressed = {})
            }
        }
    }
}

@Composable
fun Screen(categories: List<Category>, onClick: (Genre) -> Unit) {
    CategoryList(categories = categories, onClick = onClick)
}
@Composable
fun CategoryList(
    categories: List<Category>,
    onClick: (Genre) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(categories) { category ->
            CategoryItemRow(item = category, onItemClick = onClick)

        }
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CategoryItemRow(
    item: Category,
    onItemClick: (Genre) -> Unit,
    modifier: Modifier = Modifier) {
    Card(elevation = 5.dp,
            onClick = {
                onItemClick(item.genre as Genre)
            }) {
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

@Preview
@Composable
fun ScreenPreview() {
    VeronaCityTheme {
        App()
    }
}