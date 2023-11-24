package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uf1_proyecto.databinding.FragmentCharacterGalleryBinding

class CharacterGalleryFragment : Fragment() {
    lateinit var binding_: FragmentCharacterGalleryBinding
    val binding = binding_!!
    val view = binding.root
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.button.setOnClickListener {
            //go to character editor activity

        }

        return inflater.inflate(R.layout.fragment_character_gallery, container, false)
    }

}