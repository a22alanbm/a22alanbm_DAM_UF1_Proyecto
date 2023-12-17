package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.uf1_proyecto.character.CharacterViewModel
import com.example.uf1_proyecto.databinding.FragmentCharacterCaracteristicasBinding
import com.example.uf1_proyecto.databinding.FragmentCharacterGalleryBinding

class CharacterCaracteristicasFragment : Fragment() {
    private var _binding: FragmentCharacterCaracteristicasBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterCaracteristicasBinding.inflate(inflater, container, false)

        val view = binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_character_caracteristicas, container, false)


        var Personaje = CharacterViewModel.getPersonaje()

        return view
    }


}