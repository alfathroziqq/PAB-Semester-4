package com.l0122012.alfathroziq.responsi1pab.ui.faculty

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.responsi1pab.R

class ListFacultyAdapter(private val context: Context, private val listFaculty: ArrayList<Faculty>) : RecyclerView.Adapter<ListFacultyAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_faculty, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFaculty.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, img) = listFaculty[position]
        holder.imgPhoto.setImageResource(img)
        holder.tvName.text = name
        holder.tvDescription.text = desc
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listFaculty[holder.adapterPosition]) }

        holder.itemView.setOnClickListener{
            val detailsIntent = Intent(context, DetailFaculty::class.java)
            detailsIntent.putExtra(DetailFaculty.EXTRA_NAME, name)
            detailsIntent.putExtra(DetailFaculty.EXTRA_DESC, desc)
            detailsIntent.putExtra(DetailFaculty.EXTRA_IMG, img)
            context.startActivity(detailsIntent)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Faculty)
    }
}