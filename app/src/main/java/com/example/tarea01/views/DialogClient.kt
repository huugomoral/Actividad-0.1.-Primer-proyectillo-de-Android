package com.example.tarea01.views

class DialogClient {

    private var onAdd: ((String, String, String) -> Unit)? = null
    private var onUpdate: ((Int, String, String, String) -> Unit)? = null
    private var onDelete: ((Int) -> Unit)? = null

    fun setOnAddListener(listener: (nombre: String, apellido: String, telefono: String) -> Unit) {
        this.onAdd = listener
    }

    fun setOnUpdateListener(listener: (id: Int, nombre: String, apellido: String, telefono: String) -> Unit) {
        this.onUpdate = listener
    }

    fun setOnDeleteListener(listener: (id: Int) -> Unit) {
        this.onDelete = listener
    }

    fun show(action: String, id: Int = -1) {
        when (action) {
            "ADD" -> {
                onAdd?.invoke("Carlos", "Sánchez Ruiz", "677889900")
            }
            "UPDATE" -> {
                onUpdate?.invoke(id, "CAMBIADO", "MODIFICADO", "600000000")
            }
            "DELETE" -> {
                onDelete?.invoke(id)
            }
        }
    }
}