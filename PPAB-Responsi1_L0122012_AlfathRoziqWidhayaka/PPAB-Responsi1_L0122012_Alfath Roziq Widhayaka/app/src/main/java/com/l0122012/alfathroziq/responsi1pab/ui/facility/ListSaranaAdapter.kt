package com.l0122012.alfathroziq.responsi1pab.ui.facility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.responsi1pab.R

class ListSaranaAdapter(private val listSarana: ArrayList<Sarana>) : RecyclerView.Adapter<ListSaranaAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo_sarana)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name_sarana)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_sarana, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listSarana.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, _, img) = listSarana[position]
        holder.imgPhoto.setImageResource(img)
        holder.tvName.text = name
    }
}