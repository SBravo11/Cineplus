package com.cibertec.cineplus.entities

data class Movie(
    val id: Int,
    val titulo: String,
    val idioma: String,
    val estadoCartelera: String,
    val sinopsis: String,
    val formato: String,
    val portada: String
)