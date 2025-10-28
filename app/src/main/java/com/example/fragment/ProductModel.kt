package com.example.fragment

data class ProductModel(
    val image: String,
    val title: String,
    val price: Double,
    val rating: Rating,
    val description: String
)

data class Rating(
    val rate: Double,
    val count: Int
)
