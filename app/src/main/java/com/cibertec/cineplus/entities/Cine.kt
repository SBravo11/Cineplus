package com.cibertec.cineplus.entities

data class Cine(
    val id: Int,
    val nombre: String,
    val direccion: String,
    val latitud: Double,
    val longitud: Double
)