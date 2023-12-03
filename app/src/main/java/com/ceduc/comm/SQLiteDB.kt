package com.ceduc.comm

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast




class SQLiteDB (context: Context):SQLiteOpenHelper(context,"productos", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE producto (id INTEGER PRIMARY KEY AUTOINCREMENT, codigo VARCHAR(40), descripcion VARCHAR(50), precio VARCHAR(20))"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var dropQuery = "DROP TABLE IF EXISTS producto"
        db?.execSQL(dropQuery)
    }

    fun agregarDatos(codigo:String, descripcion:String, precio: String){
        val bdEditable = this.writableDatabase
        val contenedor = ContentValues()

        contenedor.put("codigo", codigo)
        contenedor.put("descripcion", descripcion)
        contenedor.put("precio", precio)

        bdEditable.insert("producto", null, contenedor)
        bdEditable.close()


    }

    fun borrarDatos(txtCodigo:String, txtDesc: String, txtPrecio: String){
        val db = this.writableDatabase

        if (!txtCodigo.isEmpty()){
            val cant = db.delete("producto", "codigo='"+txtCodigo+"'",null)

            if(cant>0){
                Toast.makeText(Formulario(),"El producto fue eliminado", Toast.LENGTH_LONG).show()
                }else{
                Toast.makeText(Formulario(),"No se ha encontrado el producto", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(Formulario(),"El campo no puede estar vacio", Toast.LENGTH_LONG).show()
        }
        txtCodigo==""
        txtDesc==""
        txtPrecio==""

    }

    fun actualizarDatos(txtCodigo:String, txtDesc:String, txtPrecio: String){
        val db = this.writableDatabase
        val contenedor = ContentValues()

        if(!txtCodigo.isEmpty() && !txtDesc.isEmpty() && !txtPrecio.isEmpty()){
            contenedor.put("codigo", txtCodigo)
            contenedor.put("descripcion", txtDesc)
            contenedor.put("precio", txtPrecio)

            db.update("producto",contenedor, "codigo='$txtCodigo'", null)

    }
}
}