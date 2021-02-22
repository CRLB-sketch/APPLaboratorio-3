package com.example.lab03

/**
 * <h1> Laboratorio 3 - Recycler View Noticias </h1>
 * <h2> Long Click Listener </h2>
 *
 * Esta interface tendrá el método fundamental para obtener la posición/index
 * del item seleccionado solo un click largo.
 *
 * <p> Desarrollo de Plataformas Moviles - Universidad del Valle de Guatemala </p>
 *
 * Creado por:
 * @author Cristian Laynez
 * @version 1.0
 * @since 2020 - Febrero - 21
 *
 **/

import android.view.View

interface LongClickListener {

    fun onItemLongClicked(view: View, position: Int)

}