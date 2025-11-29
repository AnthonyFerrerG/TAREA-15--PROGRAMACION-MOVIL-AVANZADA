package com.example.preferenciasapp

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonClear: Button
    private lateinit var textViewStored: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        buttonSave = findViewById(R.id.buttonSave)
        buttonClear = findViewById(R.id.buttonClear)
        textViewStored = findViewById(R.id.textViewStored)

        val prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Mostrar el nombre guardado al iniciar la app
        val storedName = prefs.getString("name", "")
        textViewStored.text = "Nombre guardado: $storedName"

        // Guardar nombre
        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()

            prefs.edit().putString("name", name).apply()

            textViewStored.text = "Nombre guardado: $name"
        }

        // Borrar preferencias
        buttonClear.setOnClickListener {
            prefs.edit().clear().apply()

            textViewStored.text = "Nombre guardado: "
        }
    }
}
