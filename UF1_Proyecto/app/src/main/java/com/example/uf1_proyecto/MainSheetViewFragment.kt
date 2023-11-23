package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar


class MainSheetViewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val toolbar = view?.findViewById<MaterialToolbar>(R.id.toolbar)
        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.sheet_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        val drawerLayout = view?.findViewById<DrawerLayout>(R.id.drawer_layout)
        val builder = AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(drawerLayout)
        val appBarConfiguration = builder.build()
        toolbar?.setupWithNavController(navController, appBarConfiguration)
        return inflater.inflate(R.layout.fragment_main_sheet_view, container, false)
    }

}