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
import com.example.uf1_proyecto.databinding.ActivityCharacterEditorBinding
import com.example.uf1_proyecto.databinding.FragmentCharacterCaracteristicasBinding
import com.example.uf1_proyecto.databinding.FragmentCharacterGalleryBinding

class CharacterCaracteristicasFragment : Fragment() {
    private var _binding: FragmentCharacterCaracteristicasBinding? = null

    private var _bindingActivity: ActivityCharacterEditorBinding? = null
    private val binding get() = _binding!!
    //private val bindingActivity get() = _bindingActivity!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterCaracteristicasBinding.inflate(inflater, container, false)
        val view = binding.root
        //val viewActivity = bindingActivity.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_character_caracteristicas, container, false)


        var Personaje = CharacterViewModel.getPersonaje()

        refresh()
        binding.ForNum.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!binding.ForNum.text.isEmpty()){
                    Personaje?.caracteristicas?.fortaleza?.valor = binding.ForNum.text.toString()?.toInt()
                }
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        binding.IntNum.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!binding.IntNum.text.isEmpty()){
                    Personaje?.caracteristicas?.inteligencia?.valor = binding.IntNum.text.toString()?.toInt()
                }
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        binding.RefNum.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!binding.RefNum.text.isEmpty()) {
                    Personaje?.caracteristicas?.reflejos?.valor =binding.RefNum.text.toString()?.toInt()
                }
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        binding.VolNum.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!binding.VolNum.text.isEmpty()) {
                    Personaje?.caracteristicas?.voluntad?.valor =binding.VolNum.text.toString()?.toInt()
                }
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


        binding.ForText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Personaje?.caracteristicas?.fortaleza?.frase = binding.ForText.text.toString()
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        binding.IntText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Personaje?.caracteristicas?.inteligencia?.frase = binding.IntText.text.toString()
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        binding.RefText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Personaje?.caracteristicas?.reflejos?.frase = binding.RefText.text.toString()
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        binding.VolText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Personaje?.caracteristicas?.voluntad?.frase = binding.VolText.text.toString()
                CharacterViewModel.actualizarPersonaje(Personaje!!)
                CharacterViewModel.guardarGson()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        //bindingActivity.imageButtonRight.setOnClickListener {
        //    CharacterViewModel.siguientePersonaje()
        //    refresh()
        //}
        //bindingActivity.imageButtonLeft.setOnClickListener {
        //    CharacterViewModel.anteriorPersonaje()
        //    refresh()
        //}

        return view
    }

    private fun refresh() {
        var Personaje = CharacterViewModel.getPersonaje()

        if(Personaje?.caracteristicas?.fortaleza?.valor == null){
            binding.ForNum.setText(0)
        }else{
            binding.ForNum.setText(Personaje?.caracteristicas?.fortaleza?.valor.toString())
        }

        if(Personaje?.caracteristicas?.inteligencia?.valor == null){
            binding.IntNum.setText(0)
        }else{
            binding.IntNum.setText(Personaje?.caracteristicas?.inteligencia?.valor.toString())
        }
        if(Personaje?.caracteristicas?.reflejos?.valor == null){
            binding.RefNum.setText(0)
        }else{
            binding.RefNum.setText(Personaje?.caracteristicas?.reflejos?.valor.toString())
        }
        if(Personaje?.caracteristicas?.voluntad?.valor == null){
            binding.VolNum.setText(0)
        }else{
            binding.VolNum.setText(Personaje?.caracteristicas?.voluntad?.valor.toString())
        }

        if (Personaje?.caracteristicas?.fortaleza?.frase == null){
            binding.ForText.setText("")
        }else{
            binding.ForText.setText(Personaje?.caracteristicas?.fortaleza?.frase.toString())
        }
        if (Personaje?.caracteristicas?.inteligencia?.frase == null){
            binding.IntText.setText("")
        }else{
            binding.IntText.setText(Personaje?.caracteristicas?.inteligencia?.frase.toString())
        }
        if (Personaje?.caracteristicas?.reflejos?.frase == null){
            binding.RefText.setText("")
        }else{
            binding.RefText.setText(Personaje?.caracteristicas?.reflejos?.frase.toString())
        }
        if (Personaje?.caracteristicas?.voluntad?.frase == null){
            binding.VolText.setText("")
        }else{
            binding.VolText.setText(Personaje?.caracteristicas?.voluntad?.frase.toString())
        }
    }


}