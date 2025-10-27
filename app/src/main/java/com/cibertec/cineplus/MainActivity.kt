package com.cibertec.cineplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cibertec.cineplus.databinding.ActivityMainBinding
import com.cibertec.cineplus.entities.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cambiarFragmento(Inicio())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.bottom_inicio -> cambiarFragmento(Inicio())
                R.id.bottom_cines -> cambiarFragmento(Cine())
                R.id.bottom_cuenta -> cambiarFragmento(Cuenta())
                else -> {

                }
            }
            true
        }
    }

    private fun cambiarFragmento(fragment: Fragment){
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayoutInicio, fragment)
        fragmentTransaction.commit()
    }

    fun irAPeliculaDetalle(movieId: Int) {
        val fragmentoDetalle = PeliculaDetalle()

        // 2. Pasa solo el ID en el Bundle
        val bundle = Bundle().apply {
            putInt("pelicula_id", movieId)
        }
        fragmentoDetalle.arguments = bundle

        // La transacción del fragmento es la misma
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutInicio, fragmentoDetalle)
            .addToBackStack(null)
            .commit()
    }

    fun irAPeliculaDetalleComprar(movieId: Int) {
        val fragmentoComprar = PeliculaDetalleComprar()

        val bundle = Bundle().apply {
            putInt("pelicula_id", movieId)
        }
        fragmentoComprar.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutInicio, fragmentoComprar)
            .addToBackStack(null) // Importante para que el botón "atrás" funcione
            .commit()
    }
    fun irAPeliculaButaca(movieId: Int) {
        val fragmentoButaca = PeliculaButaca()

        val bundle = Bundle().apply {
            putInt("pelicula_id", movieId)
        }
        fragmentoButaca.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutInicio, fragmentoButaca)
            .addToBackStack(null)
            .commit()
    }
}