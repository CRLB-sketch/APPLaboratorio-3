package com.example.lab03

/**
 * <h1> Laboratorio 3 - Recycler View Noticias </h1>
 * <h2> Click Listener </h2>
 *
 * Esta interface tendrá el método fundamental para obtener la posición/index
 * del item seleccionado solo con un click rapida.
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

interface ClickListener {

    fun onItemClicked(view: View, position: Int)

}