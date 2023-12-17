package com.example.uf1_proyecto.character

import androidx.lifecycle.ViewModel

class CharacterViewModel: ViewModel() {


    //personajesList.add(personajeNuevo)
    init {
        if (personajesList.size == 0) {
            var personajeNuevo: Personaje = Personaje()

            personajeNuevo.datos?.nombre = "Nombre"
            personajeNuevo.datos?.concepto = "Concepto"

            personajesList.add(personajeNuevo)
        }

    }

    companion object {


        lateinit var personajeSeleccionado: Personaje
        var personajesList : MutableList<Personaje> = mutableListOf()


        fun addPersonaje(Personaje: Personaje){
            personajesList.add(Personaje)

        }
        fun removePersonaje(Personaje: Personaje){
            personajesList.remove(Personaje)

        }
        fun getPersonaje(): Personaje{
            return personajeSeleccionado
        }
    }



}