package com.cibertec.cineplus

import android.content.ContentValues
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.cibertec.cineplus.databinding.FragmentPeliculaDetalleComprarBinding
import com.cibertec.cineplus.db.Venta_boleto
import com.cibertec.cineplus.db.VentaDbHelper
import com.cibertec.cineplus.supabaseClient.CinesData
import com.cibertec.cineplus.supabaseClient.LocalMoviesData

class PeliculaDetalleComprar : Fragment() {

    private var _binding: FragmentPeliculaDetalleComprarBinding? = null
    private val binding get() = _binding!!

    private lateinit var dbHelper: VentaDbHelper
    private var peliculaId: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeliculaDetalleComprarBinding.inflate(inflater, container, false)
        dbHelper = VentaDbHelper(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        peliculaId = arguments?.getInt("pelicula_id", -1) ?: -1

        // Aquí puedes rellenar las vistas de la película si es necesario
        val pelicula = LocalMoviesData.getPeliculasDestacadas().find { it.id == peliculaId }
        if (pelicula != null) {
            binding.txtTituloPelicula.text = pelicula.titulo
            Glide.with(this).load(pelicula.portada).into(binding.imgPelicula)
        }

        // Se llama a la función para configurar el Spinner
        setupCinesSpinner()

        val horaClickListener = View.OnClickListener { v ->
            val horaSeleccionada = (v as Button).text.toString()
            val cineSeleccionado = binding.listaCinesPelicula.selectedItem.toString()
            guardarSeleccionYNavegar(cineSeleccionado, horaSeleccionada)
        }

        binding.btnHorario1PeliculaComprar.setOnClickListener(horaClickListener)
        binding.btnHorario2PeliculaComprar.setOnClickListener(horaClickListener)

        // Configuración de otros botones
        binding.btnVolver.setOnClickListener { parentFragmentManager.popBackStack() }
        binding.btnDetallePelicula.setOnClickListener { parentFragmentManager.popBackStack() }
    }

    private fun guardarSeleccionYNavegar(cine: String, hora: String) {
        val db = dbHelper.writableDatabase
        db.delete(Venta_boleto.tbVenta.TABLE_NAME, null, null)

        val values = ContentValues().apply {
            put(Venta_boleto.tbVenta.COLUMN_PELICULA_ID, peliculaId)
            put(Venta_boleto.tbVenta.COLUMN_CINE_NOMBRE, cine)
            put(Venta_boleto.tbVenta.COLUMN_HORA_SELECCIONADA, hora)
        }

        val newRowId = db.insert(Venta_boleto.tbVenta.TABLE_NAME, null, values)

        if (newRowId != -1L && activity is MainActivity) {
            (activity as MainActivity).irAPeliculaButaca(peliculaId)
        }
    }

    // --- AQUÍ VA LA FUNCIÓN QUE FALTABA ---
    private fun setupCinesSpinner() {
        val cines = CinesData.obtenerCines()
        val nombresDeCines = cines.map { it.nombre }

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            nombresDeCines
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.listaCinesPelicula.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}