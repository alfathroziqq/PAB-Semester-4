package com.l0122012.alfathroziq.pabweek5

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMobilAdapter (private val context: Context, private val listMobil: ArrayList<Mobil>) : RecyclerView.Adapter<ListMobilAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.logoCar1)
        val tvName: TextView = itemView.findViewById(R.id.nameCar1)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_logo, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMobil.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, img) = listMobil[position]
        holder.imgPhoto.setImageResource(img)
        holder.tvName.text = name
        holder.tvDescription.text = desc

        holder.itemView.setOnClickListener{
            val detailsIntent = Intent(context, IsiDetail::class.java)
            detailsIntent.putExtra(IsiDetail.EXTRA_NAME, name)
            detailsIntent.putExtra(IsiDetail.EXTRA_DESC, desc)
            detailsIntent.putExtra(IsiDetail.EXTRA_IMG, img)
            context.startActivity(detailsIntent)
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Mobil)
    }
}