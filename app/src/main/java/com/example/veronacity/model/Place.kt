package com.example.veronacity.model

open class Category(
    val name: String,
    val description: String,
    val image: Int,
    val genre: Enum<Genre>
)
class Place(
    val id: Int,
    name: String,
    description: String,
    image: Int,
    genre: Enum<Genre>
): Category(name,description,image, genre)