package com.ceduc.comm

import android.content.Intent
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var baseDatos:SQLiteDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        baseDatos = SQLiteDB(this)

        val btnDron = findViewById<ImageButton>(R.id.btnDron)
        val btnTV = findViewById<ImageButton>(R.id.btnTV)
        val btnAudio = findViewById<ImageButton>(R.id.btnAudio)
        val btnVR = findViewById<ImageButton>(R.id.btnVR)

        val btnVerCarrito = findViewById<Button>(R.id.btnVerCarrito)
        val btnListar = findViewById<Button>(R.id.btnListar)

        val txtListado = findViewById<TextView>(R.id.txtListado)


        btnDron.setOnClickListener(){
            if (tieneDatosEnTabla()) {
                val db: SQLiteDatabase = baseDatos.readableDatabase
                val cursor = db.rawQuery("SELECT * FROM producto WHERE codigo LIKE '%Dron%'", null)

                if (cursor.moveToFirst()) {
                    val i = Intent(this@MainActivity, Formulario::class.java)
                    i.putExtra("codigo", cursor.getString(1))
                    i.putExtra("desc", cursor.getString(2))
                    i.putExtra("precio", cursor.getString(3))
                    startActivity(i)
                } else {
                    val i = Intent(this@MainActivity, Formulario::class.java)
                    startActivity(i)
                }
                cursor.close()
        }
        }
        btnTV.setOnClickListener(){
            if (tieneDatosEnTabla()) {
                val db: SQLiteDatabase = baseDatos.readableDatabase
                val cursor = db.rawQuery("SELECT * FROM producto WHERE codigo LIKE '%TV%'", null)

                if (cursor.moveToFirst()) {
                    val i = Intent(this@MainActivity, Formulario::class.java)
                    i.putExtra("codigo", cursor.getString(1))
                    i.putExtra("desc", cursor.getString(2))
                    i.putExtra("precio", cursor.getString(3))
                    startActivity(i)
                } else {
                    val i = Intent(this@MainActivity, Formulario::class.java)
                    startActivity(i)
                }
                cursor.close()
            }

        }
        btnAudio.setOnClickListener(){
            if (tieneDatosEnTabla()) {
                val db: SQLiteDatabase = baseDatos.readableDatabase
                val cursor = db.rawQuery("SELECT * FROM producto WHERE codigo LIKE '%Audio%'", null)

                if (cursor.moveToFirst()) {
                    val i = Intent(this@MainActivity, Formulario::class.java)
                    i.putExtra("codigo", cursor.getString(1))
                    i.putExtra("desc", cursor.getString(2))
                    i.putExtra("precio", cursor.getString(3))
                    startActivity(i)
                } else {
                    val i = Intent(this@MainActivity, Formulario::class.java)
                    startActivity(i)
                }
                cursor.close()
            }

        }
        btnVR.setOnClickListener(){
            if (tieneDatosEnTabla()) {
                val db: SQLiteDatabase = baseDatos.readableDatabase
                val cursor = db.rawQuery("SELECT * FROM producto WHERE codigo LIKE '%VR%'", null)

                if (cursor.moveToFirst()) {
                    val i = Intent(this@MainActivity, Formulario::class.java)
                    i.putExtra("codigo", cursor.getString(1))
                    i.putExtra("desc", cursor.getString(2))
                    i.putExtra("precio", cursor.getString(3))
                    startActivity(i)
                } else {
                    val i = Intent(this@MainActivity, Formulario::class.java)
                    startActivity(i)
                }
                cursor.close()
            }

        }

        btnVerCarrito.setOnClickListener(){
            if (tieneDatosEnTabla()) {
                val db:SQLiteDatabase = baseDatos.readableDatabase
                val cursor = db.rawQuery("SELECT * FROM producto", null)
                while (cursor.moveToNext()) {
                    val i = Intent(this, Carrito::class.java)
                    i.putExtra("codigo", cursor.getString(1) )
                    i.putExtra("desc", cursor.getString(2))
                    i.putExtra("precio", cursor.getString(3))
                    startActivity(i)
                }
            } else {

                val intent = Intent(this, Carrito::class.java)
                startActivity(intent)
            }

        }

        btnListar.setOnClickListener(){
            val db:SQLiteDatabase = baseDatos.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM producto", null)
            txtListado.text=""
            while (cursor.moveToNext()) {
                txtListado.append(cursor.getString(1))
                txtListado.append(cursor.getString(2))
                txtListado.append(cursor.getString(3))
            }

        }

    }
    fun tieneDatosEnTabla(): Boolean {
        val db:SQLiteDatabase = baseDatos.readableDatabase
        val count = DatabaseUtils.queryNumEntries(db, "producto")
        db.close()
        return count > 0
    }



}