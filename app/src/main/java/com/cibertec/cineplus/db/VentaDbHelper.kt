package com.cibertec.cineplus.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.cibertec.cineplus.db.Venta_boleto.tbVenta

class VentaDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "CinePlus.db"
    }

    // Este método se llama solo la primera vez que se accede a la BD
    override fun onCreate(db: SQLiteDatabase) {
        val SQL_CREATE_VENTAS_TABLE = """
            CREATE TABLE ${Venta_boleto.tbVenta.TABLE_NAME} (
                ${Venta_boleto.tbVenta.COLUMN_PELICULA_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${Venta_boleto.tbVenta.COLUMN_CINE_NOMBRE} TEXT NOT NULL,
                ${Venta_boleto.tbVenta.COLUMN_HORA_SELECCIONADA} TEXT NOT NULL
            )
        """.trimIndent()
        db.execSQL(SQL_CREATE_VENTAS_TABLE)
    }

    // Este método se llama si incrementas DATABASE_VERSION (para actualizaciones)
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${Venta_boleto.tbVenta.TABLE_NAME}")
        onCreate(db)
    }
}