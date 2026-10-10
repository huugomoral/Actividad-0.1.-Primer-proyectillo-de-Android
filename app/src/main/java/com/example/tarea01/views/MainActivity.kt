package com.example.tarea01.views

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea01.R
import com.example.tarea01.logic.ClientController

class MainActivity : AppCompatActivity() {

    private val controller = ClientController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testCrudFlow()
    }

    private fun testCrudFlow() {
        val dialog = DialogClient()

        dialog.setOnAddListener { nombre, apellido, telefono ->
            controller.addClient(nombre, apellido, telefono)
        }
        dialog.show("ADD")

        val idToUpdate = controller.getRandomClientId()
        if (idToUpdate != null) {
            dialog.setOnUpdateListener { id, nombre, apellido, telefono ->
                controller.updateClient(id, nombre, apellido, telefono)
            }
            dialog.show("UPDATE", idToUpdate)
        }

        // 3. Eliminar aleatorio
        val idToDelete = controller.getRandomClientId()
        if (idToDelete != null) {
            dialog.setOnDeleteListener { id ->
                controller.deleteClient(id)
            }
            dialog.show("DELETE", idToDelete)
        }
    }
}