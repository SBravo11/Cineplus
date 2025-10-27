package com.cibertec.cineplus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.cibertec.cineplus.databinding.FragmentPeliculaDetalleBinding
import com.cibertec.cineplus.supabaseClient.LocalMoviesData // Importa tu fuente de datos

class PeliculaDetalle : Fragment() {

    private var _binding: FragmentPeliculaDetalleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeliculaDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Recibe el ID de la película del bundle
        val peliculaId = arguments?.getInt("pelicula_id", -1) ?: -1

        if (peliculaId != -1) {
            // 2. Busca la película completa usando el ID
            val pelicula = LocalMoviesData.getPeliculasDestacadas().find { it.id == peliculaId }

            if (pelicula != null) {
                // 3. Rellena las vistas (igual que antes)
                binding.txtTituloPelicula.text = pelicula.titulo
                binding.txtSinopsisPelicula.text = pelicula.sinopsis
                binding.txtIdiomaDisponiblePelicula.text = pelicula.idioma
                binding.txtTiposPelicula1.text = pelicula.formato

                Glide.with(this)
                    .load(pelicula.portada)
                    .into(binding.imgPelicula)
            }
        }

        // Configura el botón de volver
        binding.btnVolver.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.btnDetalleComprarPelicula.setOnClickListener {
            if (activity is MainActivity && peliculaId != -1) {
                // Llama a la nueva función en MainActivity
                (activity as MainActivity).irAPeliculaDetalleComprar(peliculaId)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}