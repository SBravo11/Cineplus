package com.cibertec.cineplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.cibertec.cineplus.databinding.ActivityMainBinding

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
                R.id.bottom_dulceria -> cambiarFragmento(Dulceria())
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
}