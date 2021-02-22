package com.example.lab03

/**
 * <h1> Laboratorio 3 - Recycler View Noticias </h1>
 * <h2> Main Activity </h2>
 *
 * Clase para inicializar y tener el control del programa
 *
 * <p> Desarrollo de Plataformas Moviles - Universidad del Valle de Guatemala </p>
 *
 * Creado por:
 * @author Cristian Laynez
 * @version 1.0
 * @since 2020 - Febrero - 21
 *
 **/

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var list: RecyclerView? = null
    var adapter0: AdapterCustom? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    var isActionMode = false

    companion object {
        var notices:ArrayList<Notice>? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Aquí comenzará el código

        // Instanciar los botones
        val btnAdd = findViewById<Button>(R.id.btAdd)

        // Para guardar las noticias
        notices = ArrayList()

        // Agregaremos algunas noticias
        notices?.add(Notice(R.drawable.noticia01, "Noticia #01", "Noticias Positivas el COVID esta apunto de desaparecer :V"))
        notices?.add(Notice(R.drawable.noticia02, "Noticia #02", "El estafador termina estafado XdXd"))
        notices?.add(Notice(R.drawable.noticia03, "Noticia #03", "Fuimos timados por una noticia falsa"))

        refreshLayout()

        // Para agregar una nueva noticia
        btnAdd.setOnClickListener{
            Toast.makeText(applicationContext, "Nueva Noticia Agregada :D", Toast.LENGTH_SHORT).show()
            notices?.add(Notice(R.drawable.noticia05, "NOTICIA NUEVA!!!", "Breaking NEWS!!! Esta noticia a sido agregada a ultima hora!! :D"))

            refreshLayout()
        }

        // Para hacer funcioanr los Click Listeners
        adapter0 = AdapterCustom(notices!!, object:ClickListener{
            // Click simple/rapido (Para Borrar la noticia deseada)
            override fun onItemClicked(view: View, position: Int) {
                notices?.removeAt(position)

                refreshLayout()
            }
        }, object: LongClickListener{
            // Click sostenido (Para "actualizar" noticia)
            override fun onItemLongClicked(view: View, position: Int) {

                // Aquí ya se actualizará la noticia
                notices?.get(position)?.image = R.drawable.noticia04
                notices?.get(position)?.title = "Noticia Actualizada"
                notices?.get(position)?.description = "Esta noticia acaba de ser actualizada ;)"

                refreshLayout()
            }
        })

        list?.adapter = adapter0
    }

    private fun refreshLayout(){
        list = findViewById(R.id.the_list)
        list?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        list?.layoutManager = layoutManager
    }
}