package com.example.uf1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class CharacterEditorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_editor)
        //Hacer nuestra barra de actividad nuestra barra principal
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Controlador de navegación - Host de navegación (grafo asociado)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.sheet_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        //Panel Lateral - Referencia Drawer Layout
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val builder = AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(drawerLayout)

        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setupWithNavController(navController)

        setContentView(R.layout.activity_character_editor)
    }
}