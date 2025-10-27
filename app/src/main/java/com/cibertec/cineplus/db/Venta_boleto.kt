package com.cibertec.cineplus.db

import android.provider.BaseColumns

object Venta_boleto {
    object tbVenta : BaseColumns {
        const val TABLE_NAME = "venta_temporal"
        const val COLUMN_PELICULA_ID = "pelicula_id"
        const val COLUMN_CINE_NOMBRE = "cine_nombre"
        const val COLUMN_HORA_SELECCIONADA = "hora_seleccionada"
        // Futuras columnas: COLUMN_ASIENTOS, COLUMN_TOTAL, etc.
    }
}