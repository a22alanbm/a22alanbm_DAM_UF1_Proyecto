package com.example.uf1_proyecto

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uf1_proyecto.character.CharacterViewModel
import com.example.uf1_proyecto.character.Personaje
import com.example.uf1_proyecto.character.PersonajeAdapter
import com.example.uf1_proyecto.databinding.FragmentCharacterGalleryBinding


class CharacterGalleryFragment : Fragment() {
    private var _binding: FragmentCharacterGalleryBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterGalleryBinding.inflate(inflater, container, false)

        val view = binding.root





            var personajesList = CharacterViewModel.personajesList
            //Log.i("Funciona la lista?", personajesList.get(0).datos?.nombre.toString())

            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

            val adapter = PersonajeAdapter(personajesList)
            binding.recyclerView.adapter = adapter

            var button = view.findViewById<View>(R.id.plussymbol)
//
            button.setOnClickListener {
                var personajeNuevo: Personaje = Personaje()
                personajeNuevo.datos?.nombre = "Nuevo"
                personajeNuevo.datos?.concepto = "Nuevo"
                CharacterViewModel.addPersonaje(personajeNuevo)
                adapter.refresh()
            }

        //}
        return view
    }


}


