package com.cibertec.cineplus.supabaseClient

import com.cibertec.cineplus.entities.Cine

object CinesData {
    fun obtenerCines(): List<Cine> {
        return listOf(
            Cine(1, "Cine Estelar", "Av. Javier Prado Este 4200, Lima", -12.0906, -76.9713),
            Cine(2, "Multicentro Surco", "Calle Monte de los Olivos 123, Santiago de Surco", -12.1458, -76.9912),
            Cine(3, "Teatro Aurora", "Jr. Cusco 456, Cercado de Lima", -12.0464, -77.0428),
            Cine(4, "Cineplanet San Miguel", "Av. La Marina 2000, San Miguel", -12.0781, -77.0803),
            Cine(5, "Centro Cultural Andino", "Av. Arequipa 1500, Lima", -12.0965, -77.0332),
            Cine(6, "Cinemark Primavera", "Av. Angamos Este 2681, Surquillo", -12.1129, -76.9967),
            Cine(7, "Estación Cine", "Av. Benavides 3890, Miraflores", -12.1297, -77.0164),
            Cine(8, "Cine Real Plaza", "Av. Salaverry 2370, Jesús María", -12.0853, -77.0497)
        )
    }
}