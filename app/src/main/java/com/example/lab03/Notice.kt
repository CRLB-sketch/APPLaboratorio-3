package com.example.lab03

/**
 * <h1> Laboratorio 3 - Recycler View Noticias </h1>
 * <h2> Notice/Noticia </h2>
 *
 * Esta clase representará y tendrá todos los atributos y estructuras
 * que necesita una Noticia.
 *
 * <p> Desarrollo de Plataformas Moviles - Universidad del Valle de Guatemala </p>
 *
 * Creado por:
 * @author Cristian Laynez
 * @version 1.0
 * @since 2020 - Febrero - 21
 *
 **/

class Notice {

    // --> Atributos
    var image: Int = 0
    var title: String = ""
    var description: String = ""

    // --> Constructor
    constructor(image:Int, title:String, description:String){
        this.image = image
        this.title = title
        this.description = description
    }
}