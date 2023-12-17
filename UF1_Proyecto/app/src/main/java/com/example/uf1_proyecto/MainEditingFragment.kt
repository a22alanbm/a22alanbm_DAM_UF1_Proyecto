package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.uf1_proyecto.character.CharacterViewModel
import com.example.uf1_proyecto.databinding.FragmentCharacterCaracteristicasBinding
import com.example.uf1_proyecto.databinding.FragmentMainEditingBinding


class MainEditingFragment : Fragment() {

    private var _binding: FragmentMainEditingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMainEditingBinding.inflate(inflater, container, false)

        val view = binding.root


        //var BotonHitos = view?.findViewById<View>(R.id.hitosFloatingActionButton)
        binding.hitosFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterHitosFragment)
        }
        binding.caracteristicasFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterCaracteristicasFragment)
        }
        binding.combateFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterCombateFragment)
        }
        binding.conceptosFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterConceptosFragment)
        }
        binding.corduraFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterCorduraFragment)
        }
        binding.distorsionFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterDistorsionFragment)
        }
        binding.dramaFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterDramaFragment)
        }
        binding.habilidadesFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterHabilidadesFragment)
        }
        binding.lazosFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterLazosFragment)
        }
        binding.saludFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterSaludFragment)
        }
        binding.equipoFloatingActionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainEditingFragment_to_characterEquipoFragment)
        }




        return view
    }

}