package com.example.uf1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.uf1_proyecto.character.CharacterViewModel

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        CharacterViewModel.directorio(getFilesDir())
        CharacterViewModel.cargarGson()
    }
}