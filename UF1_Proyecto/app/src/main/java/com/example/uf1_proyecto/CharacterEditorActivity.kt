package com.example.uf1_proyecto

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.core.view.size
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class CharacterEditorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_editor)
        //Hacer nuestra barra de actividad nuestra barra principal
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationIcon(getDrawable(R.drawable.puntitos2) )
        toolbar.overflowIcon= getDrawable(R.drawable.puntitos2)
        toolbar.collapseIcon= getDrawable(R.drawable.puntitos2)

        setSupportActionBar(toolbar?:return)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);

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

        var bottomAppBar = findViewById<BottomAppBar>(R.id.bottomBar)
        var atras = bottomAppBar.menu.getItem(0)

        bottomAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.goBack -> {
                    // Handle search icon press
                    onBackPressedDispatcher.onBackPressed()
                    true
                }

                else -> false
            }
        }


    /*

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.itemIconSize=200
        val color: Int = resources.getColor(R.color.moraro)
        //bottomNav.itemBackground = color
        //val atras =  findViewById<>(R.id.atras)
        //atras.setOnClickListener {
          //navController.popBackStack()
        //}
        //bottomNav.setupWithNavController(navController)
        */

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.sheet_container_view)
        return NavigationUI.onNavDestinationSelected(item, navController)
                ||super.onOptionsItemSelected(item)
    }
}