package com.example.uf1_proyecto

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.uf1_proyecto.character.CharacterViewModel
import com.example.uf1_proyecto.databinding.FragmentCharacterConceptosBinding


class CharacterConceptosFragment : Fragment() {
    private var _binding: FragmentCharacterConceptosBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterConceptosBinding.inflate(inflater, container, false)

        val view = binding.root

        var Personaje = CharacterViewModel.getPersonaje()
        
        if (Personaje?.datos?.concepto == null){
            binding.Concepto.setText("")
        }else{
            binding.Concepto.setText(Personaje?.datos?.concepto.toString())
        }

        if (Personaje?.datos?.nombre == null){
            binding.Nombre.setText("")
        }else{
            binding.Nombre.setText(Personaje?.datos?.nombre.toString())
        }

        if (Personaje?.datos?.cita == null){
            binding.Cita1.setText("")
            binding.Cita2.setText("")
        }else{
            var citas = Personaje?.datos?.cita.toString().split("\n")
            binding.Cita1.setText(citas[0])
            if (citas.size > 1){
                binding.Cita2.setText(citas[1])
            }else{
                binding.Cita2.setText("")
            }
        }

        binding.Concepto.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Personaje?.datos?.concepto = binding.Concepto.text.toString()
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        binding.Nombre.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Personaje?.datos?.nombre = binding.Nombre.text.toString()
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        binding.Cita1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Personaje?.datos?.cita = binding.Cita1.text.toString() + "\n" + binding.Cita2.text.toString()
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        binding.Cita2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Personaje?.datos?.cita = binding.Cita1.text.toString() + "\n" + binding.Cita2.text.toString()
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })




        // Inflate the layout for this fragment
        return view
    }

}