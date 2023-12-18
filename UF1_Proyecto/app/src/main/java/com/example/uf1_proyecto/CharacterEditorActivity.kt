package com.example.uf1_proyecto

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.uf1_proyecto.character.CharacterViewModel
import com.google.android.material.bottomappbar.BottomAppBar


class CharacterEditorActivity : AppCompatActivity() {

    //private var _binding: ActivityCharacterEditorBinding? = null
    //private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        //_binding = ActivityCharacterEditorBinding.inflate(layoutInflater)
        //val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_editor)
        val nombrePersonaje = findViewById<TextView>(R.id.nameCharacter)
        if (CharacterViewModel.personajeSeleccionado.datos?.nombre != null) {
            nombrePersonaje.setText( CharacterViewModel.personajeSeleccionado.datos?.nombre.toString())
        }
        val conceptoPersonaje = findViewById<TextView>(R.id.conceptCharacter)
        if (CharacterViewModel.personajeSeleccionado.datos?.concepto != null){
            conceptoPersonaje.setText( CharacterViewModel.personajeSeleccionado.datos?.concepto.toString())
        }
        full = true
        //Hacer nuestra barra de actividad nuestra barra principal
        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //toolbar.setNavigationIcon(getDrawable(R.drawable.puntitos2) )
        //toolbar.overflowIcon= getDrawable(R.drawable.puntitos2)
        //toolbar.collapseIcon= getDrawable(R.drawable.puntitos2)

        //setSupportActionBar(toolbar?:return)
        //getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        // Controlador de navegación - Host de navegación (grafo asociado)
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.sheet_container_view) as NavHostFragment
        //val navController = navHostFragment.navController

        //Panel Lateral - Referencia Drawer Layout
        //val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        //val builder = AppBarConfiguration.Builder(navController.graph)
        //builder.setOpenableLayout(drawerLayout)

        //val appBarConfiguration = builder.build()
        //toolbar.setupWithNavController(navController, appBarConfiguration)

        //val navigationView = findViewById<NavigationView>(R.id.nav_view)
        //navigationView.setupWithNavController(navController)

        var imageButtonRight = findViewById<ImageButton>(R.id.imageButtonRight)
        var imageButtonLeft = findViewById<ImageButton>(R.id.imageButtonLeft)
        var deletebutton = findViewById<ImageButton>(R.id.deletebutton)
        deletebutton.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)

            builder.setCancelable(true)
            var string: String = getString(R.string.eliminacionDefinitiva)
            builder.setTitle(string)
            string = getString(R.string.eliminarSegurx)
            builder.setMessage(string)
            string = getString(R.string.confirm)
            builder.setPositiveButton(string,
                DialogInterface.OnClickListener { dialog, which ->

                    CharacterViewModel.removePersonaje(CharacterViewModel.personajeSeleccionado)
                    if (!full){onBackPressedDispatcher.onBackPressed()}
                    onBackPressedDispatcher.onBackPressed()
                })
            string = getString(R.string.cancel)
            builder.setNegativeButton(string,
                DialogInterface.OnClickListener { dialog, which -> })

            val dialog: AlertDialog = builder.create()
            dialog.show()
            //CharacterViewModel.removePersonaje(CharacterViewModel.personajeSeleccionado)

        }

        imageButtonRight.setOnClickListener {
            CharacterViewModel.siguientePersonaje()
            refresh()
        }
        imageButtonLeft.setOnClickListener {
            CharacterViewModel.anteriorPersonaje()
            refresh()
        }


        var bottomAppBar = findViewById<BottomAppBar>(R.id.bottomBar)
        var atras = bottomAppBar.menu.getItem(0)

        bottomAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.goBack -> {
                    // Handle search icon press

                    full = true

                    onBackPressedDispatcher.onBackPressed()
                    true
                }

                else -> false
            }
        }

        var concepto = findViewById<TextView>(R.id.conceptCharacter)
        var nombre = findViewById<TextView>(R.id.nameCharacter)
        concepto.setOnClickListener {
            concepto.setText(CharacterViewModel.personajeSeleccionado.datos?.concepto.toString())
            nombre.setText(CharacterViewModel.personajeSeleccionado.datos?.nombre.toString())
        }
        nombre.setOnClickListener {
            concepto.setText(CharacterViewModel.personajeSeleccionado.datos?.concepto.toString())
            nombre.setText(CharacterViewModel.personajeSeleccionado.datos?.nombre.toString())
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

    private fun refresh() {
        //recreate()

        val nombrePersonaje = findViewById<TextView>(R.id.nameCharacter)
        val conceptoPersonaje = findViewById<TextView>(R.id.conceptCharacter)
        nombrePersonaje.setText( CharacterViewModel.personajeSeleccionado.datos?.nombre.toString())
        conceptoPersonaje.setText( CharacterViewModel.personajeSeleccionado.datos?.concepto.toString())
        if(!full){
            full = true
            onBackPressedDispatcher.onBackPressed()
        }





        //onBackPressedDispatcher.onBackPressed()
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


    companion object {
        var full = false
    }

}