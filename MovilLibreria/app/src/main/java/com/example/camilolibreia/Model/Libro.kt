package com.example.camilolibreia.Model

data class Libro(
    var id_libro: String,
    var titulo_libro:String,
    var autor_libro:String,
    var isbn_libro:String,
    var genero_libro:String,
    var numero_ejemplares_disponibles: String,
    var numero_ejemplares_ocupados: String

)
