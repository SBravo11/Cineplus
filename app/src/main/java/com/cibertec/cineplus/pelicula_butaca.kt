package com.cibertec.cineplus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cibertec.cineplus.databinding.FragmentPeliculaButacaBinding

class PeliculaButaca : Fragment() {

    private var _binding: FragmentPeliculaButacaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeliculaButacaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val peliculaId = arguments?.getInt("pelicula_id", -1) ?: -1
        // Aquí puedes usar el peliculaId para cargar datos si es necesario

        binding.btnVolver.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}