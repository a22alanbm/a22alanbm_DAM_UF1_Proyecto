package com.example.uf1_proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment


class CharacterGalleryFragment : Fragment() {
    //private var _binding: FragmentCharacterGalleryBinding? = null

    //private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view = binding?.root

        //binding?.button?.setOnClickListener {
            //go to character editor activity
            val view = inflater.inflate(R.layout.fragment_character_gallery, container, false)
            var button = view.findViewById<View>(R.id.button)

            button.setOnClickListener {
                //val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.fragment_container_view) as NavHostFragment
                //val navController = navHostFragment.navController
                view.findNavController().navigate(R.id.action_characterGalleryFragment_to_characterEditorActivity)
            }

        //}
        return view
    }

}