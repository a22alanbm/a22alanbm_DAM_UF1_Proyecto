package com.example.uf1_proyecto.character

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.databinding.ItemCharacterBinding


class PersonajesViewHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = ItemCharacterBinding.bind(view)
    val view2 = view

    fun render(personajeModel: Personaje) {
        binding.nameCharacter.text = personajeModel.datos?.nombre
        binding.conceptCharacter.text = personajeModel.datos?.concepto
        //Glide.with(binding.cityImage.context).load(personajeModel.photo).into(binding.cityImage)


        binding.botonCharacter.setOnClickListener {


            //val bundle = Bundle()

            CharacterViewModel.personajeSeleccionado = personajeModel

            //bundle.putString("persona", personajeModel.id.toString())

            view2.findNavController().navigate(R.id.action_characterGalleryFragment2_to_characterEditorActivity)

        }


    }
}