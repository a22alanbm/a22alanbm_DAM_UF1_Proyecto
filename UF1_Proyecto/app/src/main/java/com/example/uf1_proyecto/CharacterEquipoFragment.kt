package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uf1_proyecto.character.CharacterViewModel
import com.example.uf1_proyecto.databinding.FragmentCharacterEquipoBinding


class CharacterEquipoFragment : Fragment() {
    private var _binding: FragmentCharacterEquipoBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterEquipoBinding.inflate(inflater, container, false)

        val view = binding.root

        var Personaje = CharacterViewModel.getPersonaje()

        // Inflate the layout for this fragment
        return view
    }

}