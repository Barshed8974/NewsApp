package com.assignment.myapplication.Model

data class Response(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)