package com.ceduc.comm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Carrito : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)


        val txtCarrito = findViewById<TextView>(R.id.txtCarrito)

        val btnPagar = findViewById<Button>(R.id.btnPagar)

        txtCarrito.append(intent.getStringExtra("codigo"))
        txtCarrito.append(intent.getStringExtra("descripcion"))
        txtCarrito.append(intent.getStringExtra("precio"))

        }


}


