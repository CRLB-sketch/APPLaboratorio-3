package com.example.lab03

/**
 * <h1> Laboratorio 3 - Recycler View Noticias </h1>
 * <h2> Adapter Custom / Adaptador Personalizado </h2>
 *
 * Esta clase será nuestra adaptador personalizado, este realizará
 * toda la magia correspondiente para mostrar los datos y ponerlos.
 *
 * <p> Desarrollo de Plataformas Moviles - Universidad del Valle de Guatemala </p>
 *
 * Creado por:
 * @author Cristian Laynez
 * @version 1.0
 * @since 2020 - Febrero - 21
 *
 **/

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterCustom(items:ArrayList<Notice>, var listener:ClickListener, var longClickListener: LongClickListener): RecyclerView.Adapter<AdapterCustom.ViewHolder>() {

    var items:ArrayList<Notice>? = null
    var viewHolder: ViewHolder? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCustom.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.template_notice, parent, false)
        viewHolder = ViewHolder(view, listener, longClickListener)

        return viewHolder!!
    }

    override fun onBindViewHolder(holder: AdapterCustom.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.image?.setImageResource(item?.image!!)
        holder.title?.text = item?.title
        holder.description?.text = item?.description


    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    class ViewHolder(view: View, listener: ClickListener, longClickListener: LongClickListener): RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {

        var view = view
        var image: ImageView? = null
        var title: TextView? = null
        var description: TextView? = null
        var listener: ClickListener? = null
        var longListener: LongClickListener? = null

        init {
            image = view.findViewById(R.id.ivImage)
            title = view.findViewById(R.id.tvTitle)
            description = view.findViewById(R.id.tvDescription)

            this.listener = listener
            this.longListener = longClickListener

            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onItemClicked(v!!, adapterPosition)
        }

        override fun onLongClick(v: View?): Boolean {
            this.longListener?.onItemLongClicked(v!!, adapterPosition)
            return true
        }
    }
}