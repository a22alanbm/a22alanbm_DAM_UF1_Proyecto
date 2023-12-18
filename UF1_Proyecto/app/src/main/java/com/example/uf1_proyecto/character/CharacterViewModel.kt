package com.example.uf1_proyecto.character

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.uf1_proyecto.LoginActivity
import com.example.uf1_proyecto.MainActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File





class CharacterViewModel: ViewModel() {


    //personajesList.add(personajeNuevo)
    init {
        if (personajesList.size == 0) {
            cargarGson()
        }

    }

    companion object {

        private val gson : Gson= GsonBuilder().setPrettyPrinting().create()
        lateinit var personajeSeleccionado: Personaje
        var personajesList : MutableList<Personaje> = mutableListOf()
        lateinit var internalStorageDir: File
        lateinit var data : File

        fun addPersonaje(Personaje: Personaje){
            personajesList.add(Personaje)

        }
        fun removePersonaje(Personaje: Personaje){
            personajesList.remove(Personaje)

        }
        fun getPersonaje(): Personaje{
            return personajeSeleccionado
        }
        fun actualizarPersonaje(personaje: Personaje){
            for (i in 0..personajesList.size-1){
                if(personajesList.get(i).id == personaje.id){
                    personajesList.set(i, personaje)
                }
            }
        }
        fun serializarPersonajes(): String {
            return gson.toJson(personajesList)
        }

        fun deserializarPersonajes(jsonString: String) {
            data = File(internalStorageDir, "data.json")
            val tipoLista = object : TypeToken<MutableList<Personaje>>() {}.type
            personajesList = gson.fromJson(jsonString, tipoLista)
        }
        fun guardarGson(){
            Log.i("guardarGson", "guardarGson")
            data.writeText(serializarPersonajes())
        }
        fun cargarGson(){
            Log.i("cargarGson", "cargarGson")
            if(data.exists()){
                deserializarPersonajes(data.readText())
            }
        }

        fun directorio(directorio : File){
            internalStorageDir = directorio
            if (!internalStorageDir.exists()) {
                internalStorageDir.mkdir()
            }
            data = File(internalStorageDir, "data.json")
        }
    }



}