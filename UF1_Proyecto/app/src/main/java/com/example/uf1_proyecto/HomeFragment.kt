package com.example.uf1_proyecto


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.shape.CornerFamily


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        var button = view.findViewById<View>(R.id.button)

        button.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_characterGalleryFragment2)

        }




        return view
    }

}