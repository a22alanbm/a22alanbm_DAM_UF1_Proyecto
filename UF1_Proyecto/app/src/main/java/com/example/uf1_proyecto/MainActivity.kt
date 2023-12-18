package com.example.uf1_proyecto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Hacer nuestra barra de actividad nuestra barra principal
        val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
        toolbar.setNavigationIcon(getDrawable(R.drawable.puntitos2) )
        toolbar.overflowIcon= getDrawable(R.drawable.puntitos2)
        toolbar.collapseIcon= getDrawable(R.drawable.puntitos2)


        //if(sharedPreferences==null){
        //    sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        //}


        //val myEditor: SharedPreferences.Editor? = sharedPreferences?.edit()
        //myEditor.put

        setSupportActionBar(toolbar?:return)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        // Controlador de navegación - Host de navegación (grafo asociado)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.activity_main_fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        //Panel Lateral - Referencia Drawer Layout

        val drawerLayout = findViewById<DrawerLayout>(R.id.main_drawer_layout)
        val builder = AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(drawerLayout)


        //val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //bottomNav.itemIconSize=200
        //val color: Int = resources.getColor(R.color.moraro)
        //bottomNav.setupWithNavController(navController)



        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)

        val navigationView = findViewById<NavigationView>(R.id.main_nav_view)
        navigationView.setupWithNavController(navController)

    }
}