package com.example.camilolibreia

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.camilolibreia.Config.Config
import com.example.camilolibreia.Model.Libro
import com.google.gson.Gson


class DetalleLibro: AppCompatActivity()  {
    private lateinit var lbltitulo: TextView
    private lateinit var lblautor: TextView
    private lateinit var lblgenero: TextView
    private lateinit var lblcod_isbn: TextView
    private lateinit var lblcant_dis: TextView
    private lateinit var lblcant_ocup: TextView

    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detalle_libro)

        id = intent.getStringExtra("ID_LIBRO")

        lbltitulo = findViewById(R.id.lbltitulo)
        lblautor = findViewById(R.id.lblautor)
        lblgenero = findViewById(R.id.lblgenero)
        lblcod_isbn = findViewById(R.id.lblcod_isbn)
        lblcant_dis = findViewById(R.id.lblcant_disp)
        lblcant_ocup = findViewById(R.id.lblcant_ocup)

        consultarLibro()
    }

    private fun consultarLibro() {
        if (!id.isNullOrEmpty()) {
            val request = JsonObjectRequest(
                Request.Method.GET,
                Config.urlLibro + id,
                null,
                { response ->
                    val gson = Gson()
                    val libro: Libro = gson.fromJson(response.toString(), Libro::class.java)
                    lblautor.text = libro.autor_libro
                    lbltitulo.text = libro.titulo_libro
                    lblgenero.text = libro.genero_libro
                    lblcod_isbn.text = libro.isbn_libro
                    lblcant_dis.text = libro.numero_ejemplares_disponibles.toString()
                    lblcant_ocup.text = libro.numero_ejemplares_ocupados.toString()
                },
                { error ->
                    Toast.makeText(this, "Error al consultar: ${error.message}", Toast.LENGTH_LONG).show()
                }
            )
            Volley.newRequestQueue(this).add(request)
        }
    }
}
