package com.cibertec.cineplus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cibertec.cineplus.adapters.PeliculasAdapter
import com.cibertec.cineplus.adapters.MovieCardType
import com.cibertec.cineplus.adapters.OnMovieClickListener // Asegúrate de que este import exista
import com.cibertec.cineplus.databinding.FragmentInicioBinding
import com.cibertec.cineplus.supabaseClient.LocalMoviesData
import com.cibertec.cineplus.entities.Movie

// 1. Nombre de la interfaz corregido (OnMovieClickListener)
class Inicio : Fragment(), OnMovieClickListener {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    private lateinit var destacadasAdapter: PeliculasAdapter
    private lateinit var proximamenteAdapter: PeliculasAdapter
    private lateinit var vistosAdapter: PeliculasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        fetchAndDistributePeliculas()
    }

    private fun setupRecyclerViews() {
        // Al crear los adaptadores, pasamos 'this' como el listener
        destacadasAdapter = PeliculasAdapter(emptyList(), MovieCardType.FULL, this)
        proximamenteAdapter = PeliculasAdapter(emptyList(), MovieCardType.COMPACT, this)
        vistosAdapter = PeliculasAdapter(emptyList(), MovieCardType.COMPACT, this)

        binding.rvDestacadas.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = destacadasAdapter
        }

        binding.rvProximamente.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = proximamenteAdapter
        }

        binding.rvVistos.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = vistosAdapter
        }
    }

    private fun fetchAndDistributePeliculas() {
        val allMovies = LocalMoviesData.getPeliculasDestacadas()
        val destacadasList = allMovies.take(2)
        val proximamenteList = allMovies.drop(2).take(2)
        val vistosList = allMovies.drop(4)

        destacadasAdapter.updateData(destacadasList)
        proximamenteAdapter.updateData(proximamenteList)
        vistosAdapter.updateData(vistosList)
    }

    // 2. Se añade la palabra clave 'override'
    override fun onMovieClick(movieId: Int) {
        if (activity is MainActivity) {
            // 2. Pasa el ID a la función de MainActivity
            (activity as MainActivity).irAPeliculaDetalle(movieId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}