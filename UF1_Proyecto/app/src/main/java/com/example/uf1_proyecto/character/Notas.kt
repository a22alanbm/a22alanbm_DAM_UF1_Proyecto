package com.example.uf1_proyecto.character


class Notas internal constructor() {
    var notas: ArrayList<String>? = ArrayList()

    init {
        val notas = ArrayList<String>()
        notas.add("Notas")
    }

    fun addNota(nota: String) {
        notas!!.add(nota)
    }

    fun removeNota(nota: String) {
        notas!!.remove(nota)
    }



}
