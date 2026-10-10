package com.example.tarea01.logic

import android.util.Log
import com.example.tarea01.data.Client
import com.example.tarea01.data.ClientRepository

class ClientController {

    private val TAG = "CRUD_LOG"
    private val clientList: MutableList<Client> = ClientRepository.initialClients.toMutableList()
    private var nextId = 103

    fun addClient(nombre: String, apellido: String, telefono: String) {
        val newClient = Client(nextId++, nombre, apellido, telefono)
        clientList.add(newClient)
        Log.d(TAG, "El cliente con id = ${newClient.id}, ha sido insertado correctamente")
        Log.d(TAG, clientList.toString())
    }

    fun updateClient(id: Int, nombre: String, apellido: String, telefono: String) {
        val client = clientList.find { it.id == id }
        if (client != null) {
            client.nombre = nombre
            client.apellido = apellido
            client.telefono = telefono
            Log.d(TAG, "El cliente con id = $id, ha sido actualizado correctamente")
        }
        Log.d(TAG, clientList.toString())
    }

    fun deleteClient(id: Int) {
        val removed = clientList.removeIf { it.id == id }
        if (removed) {
            Log.d(TAG, "El cliente con id = $id, ha sido eliminado correctamente")
        }
        Log.d(TAG, clientList.toString())
    }

    fun getRandomClientId(): Int? {
        return if (clientList.isNotEmpty()) clientList.random().id else null
    }
}