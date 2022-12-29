package com.example.veronacity.datasource

import com.example.veronacity.R
import com.example.veronacity.model.Category
import com.example.veronacity.model.Genre
import com.example.veronacity.model.Place


object Datasource {
    val categories = listOf(
        Category(
            name = "Cafe",
            description = "Enjoy your free time",
            image = R.drawable.cafe,
            genre = Genre.Cafe
        ),
        Category(
            name = "Park",
            description = "Breathe in the nature",
            image = R.drawable.park,
            genre = Genre.Park
        )
    )

    val places = listOf(
        Place(
            id = 1,
            name = "Ducci Cafe",
            description = "It is in Corso Porto Nuova very close to the city center and full of delicious foods",
            image = R.drawable.ducci,
            genre = Genre.Cafe
        ),
        Place(
            id = 2,
            name = "Paganetto Cafe",
            description = "It is on Via Ghetto number 28. They have gret tea and donuts and treat their customers well",
            image = R.drawable.paganetto,
            genre = Genre.Cafe
        ),
        Place(
            id = 3,
            name = "V76 Cafe",
            description = "It is on Via Tonaro number 24. They are 24 hours open and serve goat milk",
            image = R.drawable.v76,
            genre = Genre.Cafe
        ),
        Place(
            id = 4,
            name = "Nuova Parco",
            description = "It is near Borgo Roma full of trees and it is very wide. It has a lot of games for children",
            image = R.drawable.nuovo_parco,
            genre = Genre.Park
        ),
        Place(
            id = 5,
            name = "Parco Della Salute",
            description = "It is on Via Lega Veronese. You can find monuments in there belonging to 18th Century",
            image = R.drawable.parco_della_salute,
            genre = Genre.Park
        ),
        Place(
            id = 6,
            name = "Campo Giochi",
            description = "It is near Santa Lucia. There is a trekking road and a good place for walking dogs",
            image = R.drawable.campo,
            genre = Genre.Park
        )
    )


}