package com.cibertec.cineplus.supabaseClient

import com.cibertec.cineplus.entities.Movie

object LocalMoviesData {
    fun getPeliculasDestacadas(): List<Movie> {
        return listOf(
            Movie(1, "El Viaje Inesperado", "Español", "En Cartelera", "Un joven descubre un portal a mundos paralelos y debe enfrentarse a su destino.", "Digital", "https://pics.filmaffinity.com/El_Hobbit_Un_viaje_inesperado-404389882-large.jpg"),
            Movie(2, "Shadows of Tomorrow", "Inglés", "Próximo Estreno", "En un futuro distópico, una rebelión se gesta en las sombras del sistema.", "IMAX", "https://public-files.gumroad.com/3qr764ikrg4vw1q56jqqpd2vs70s"),
            Movie(3, "La Última Nota", "Español", "En Cartelera", "Una pianista lucha por recuperar su pasión tras una tragedia personal.", "2D", "https://pics.filmaffinity.com/La_aultima_nota-992567479-large.jpg"),
            Movie(4, "Code Zero", "Inglés", "Fuera de Cartelera", "Un hacker se ve envuelto en una conspiración global que podría cambiar el mundo.", "Digital", "https://img.rgstatic.com/content/show/df59a471-3d6a-498c-896f-22b772b60f11/poster-342.jpg"),
            Movie(5, "Amor en los Andes", "Español", "En Cartelera", "Dos almas se encuentran en un viaje por las montañas peruanas.", "3D", "https://image.tmdb.org/t/p/original/8435YO9bYht0Y8MaF0jX360nO5g.jpg"),
            Movie(6, "Neon Pulse", "Inglés", "Próximo Estreno", "Una detective investiga una serie de crímenes en una ciudad iluminada por neón.", "IMAX", "https://d2x4a9e0ghkjiw.cloudfront.net/VOD/Movies/FLX/Futureworld/futureworld_poster.webp"),
            Movie(7, "El Guardián del Tiempo", "Español", "Fuera de Cartelera", "Un anciano revela que ha protegido el flujo del tiempo durante siglos.", "2D", "https://pics.filmaffinity.com/Guardians_of_Time-391533085-large.jpg"),
            Movie(8, "Silent Echoes", "Inglés", "En Cartelera", "Una periodista descubre secretos enterrados en un pueblo aparentemente tranquilo.", "Digital", "https://i1.wp.com/www.cyanidenation.com/wp-content/uploads/2018/10/Silent-Echoes-Poster.jpg?ssl=1")
        )
    }
}