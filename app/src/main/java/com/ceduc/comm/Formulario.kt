package com.ceduc.comm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Formulario : AppCompatActivity() {
    lateinit var baseDatos:SQLiteDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)
        baseDatos = SQLiteDB(this)

        val txtCodigo = findViewById<EditText>(R.id.txtCodigo)
        val txtDesc = findViewById<EditText>(R.id.txtDesc)
        val txtPrecio = findViewById<EditText>(R.id.txtPrecio)

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnActualizar = findViewById<Button>(R.id.btnActualizar)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)

        txtCodigo.setText(intent.getStringExtra("codigo"))
        txtDesc.setText(intent.getStringExtra("desc"))
        txtPrecio.setText(intent.getStringExtra("precio"))


        btnAgregar.setOnClickListener(){
            baseDatos.agregarDatos(txtCodigo.toString(), txtDesc.toString(), txtPrecio.toString())
            Toast.makeText(this,"Producto agregado al carrito", Toast.LENGTH_LONG).show()
        }
        btnActualizar.setOnClickListener(){
            baseDatos.actualizarDatos(txtCodigo.toString(), txtDesc.toString(),txtPrecio.toString())
            Toast.makeText(this,"Datos del producto actualizados", Toast.LENGTH_LONG).show()
        }
        btnBorrar.setOnClickListener(){
            baseDatos.borrarDatos(txtCodigo.toString(), txtDesc.toString(),txtPrecio.toString())
        }
    }
}