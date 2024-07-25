package com.example.camilolibreia.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.camilolibreia.DetalleLibro
import com.example.camilolibreia.Model.Libro

class LibroAdapter(private val context: Context, private val libros: List<Libro>) :
    RecyclerView.Adapter<LibroAdapter.LibroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_libro, parent, false)
        return LibroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        holder.bind(libro)
    }

    override fun getItemCount(): Int = libros.size

    inner class LibroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titulo: TextView = itemView.findViewById(R.id.titulo)
        private val autor: TextView = itemView.findViewById(R.id.autor)
        private val isbn: TextView = itemView.findViewById(R.id.isbn)
        private val genero: TextView = itemView.findViewById(R.id.genero)
        private val numEjemDis: TextView = itemView.findViewById(R.id.num_ejem_dis)
        private val numEjemOcup: TextView = itemView.findViewById(R.id.num_ejem_ocup)
        private val editarButton: Button = itemView.findViewById(R.id.btnEditar)
        private val eliminarButton: Button = itemView.findViewById(R.id.btnEliminar)

        fun bind(libro: Libro) {
            titulo.text = libro.titulo_libro
            autor.text = libro.autor_libro
            isbn.text = libro.isbn_libro
            genero.text = libro.genero_libro
            numEjemDis.text = libro.numero_ejemplares_disponibles.toString()
            numEjemOcup.text = libro.numero_ejemplares_ocupados.toString()

            editarButton.setOnClickListener {
                val intent = Intent(context, DetalleLibro::class.java)
                intent.putExtra("ID_LIBRO", libro.id_libro)
                context.startActivity(intent)
            }

            eliminarButton.setOnClickListener {
                // Implementar la funcionalidad de eliminar libro
            }
        }
    }
}
