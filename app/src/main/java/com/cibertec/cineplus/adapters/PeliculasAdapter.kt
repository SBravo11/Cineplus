package com.cibertec.cineplus.adapters

import android.view.LayoutInflater
import android.view.View // Asegúrate de importar View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cibertec.cineplus.R
import com.cibertec.cineplus.databinding.PeliculasDestacadasBinding
import com.cibertec.cineplus.entities.Movie

// Define un enum para los tipos de vista, es más limpio que usar strings o ints.
enum class MovieCardType {
    FULL,
    COMPACT
}

interface OnMovieClickListener {
    fun onMovieClick(movieId: Int)
}

class PeliculasAdapter(
    private var movies: List<Movie>,
    private val cardType: MovieCardType,
    private val listener: OnMovieClickListener
) : RecyclerView.Adapter<PeliculasAdapter.PeliculaViewHolder>() {

    inner class PeliculaViewHolder(private val binding: PeliculasDestacadasBinding) : RecyclerView.ViewHolder(binding.root) {

        // El método bind ahora también recibe el tipo de tarjeta
        fun bind(movie: Movie, cardType: MovieCardType) {
            binding.tvTitlePeliculaCard.text = movie.titulo

            Glide.with(binding.root.context)
                .load(movie.portada)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.imgPelicula)

            // Lógica para mostrar/ocultar vistas
            if (cardType == MovieCardType.COMPACT) {
                // Si es COMPACT (Próximamente), oculta el resumen y los botones
                binding.tvPeliculaResumenCard.visibility = View.GONE
                binding.btnHora1.visibility = View.GONE
                binding.btnHora2.visibility = View.GONE
            } else {
                // Si es FULL, asegúrate de que todo sea visible y establece el texto
                binding.tvPeliculaResumenCard.visibility = View.VISIBLE
                binding.btnHora1.visibility = View.VISIBLE
                binding.btnHora2.visibility = View.VISIBLE

                binding.tvPeliculaResumenCard.text = movie.sinopsis
                // Puedes dejar los textos de los botones hardcodeados o usar datos si los tuvieras
                "12:00 pm".also { binding.btnHora1.text = it }
                "14:00 pm".also { binding.btnHora2.text = it }
            }

            val clickHandler = View.OnClickListener {
                listener.onMovieClick(movie.id)
            }
            binding.btnHora1.setOnClickListener(clickHandler)
            binding.btnHora2.setOnClickListener(clickHandler)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val binding = PeliculasDestacadasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeliculaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        // Pasa el tipo de tarjeta junto con la película
        holder.bind(movies[position], cardType)
    }

    override fun getItemCount(): Int = movies.size

    fun updateData(newMovies: List<Movie>) {
        this.movies = newMovies
        notifyDataSetChanged()
    }
}
