package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController


class MainEditingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        var BotonHitos = view?.findViewById<View>(R.id.hitosFloatingActionButton)
        BotonHitos?.setOnClickListener {
            var navController = findNavController()
            navController?.navigate(R.id.action_mainEditingFragment_to_pitosYFlautasFragment)
        }

        return inflater.inflate(R.layout.fragment_main_editing, container, false)
    }

}