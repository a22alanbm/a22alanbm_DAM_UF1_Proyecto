package com.example.uf1_proyecto.character
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R
class PersonajeAdapter(private var personajesList:MutableList<Personaje>) : RecyclerView.Adapter<PersonajesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonajesViewHolder(
            layoutInflater.inflate(R.layout.item_character, parent, false)
        );
    }

    override fun onBindViewHolder(holder: PersonajesViewHolder, position: Int) {
        val item = personajesList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int { //tamaño do listado que imos ter
        return personajesList.size
    }
    fun updatePersonajes(personajesList : MutableList<Personaje>){
        this.personajesList = personajesList
        notifyDataSetChanged()

    }

    fun updatePersonaje(peronajeNuevo: Personaje) {
        this.personajesList.add(peronajeNuevo)
        notifyDataSetChanged()
    }

    fun refresh() {
        notifyDataSetChanged()
    }


}