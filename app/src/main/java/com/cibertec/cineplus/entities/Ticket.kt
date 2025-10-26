package com.cibertec.cineplus.entities

data class Ticket(
    val titulo: String,
    val descripcion: String,
    val precio: Double,
    var cantidad: Int = 0
)