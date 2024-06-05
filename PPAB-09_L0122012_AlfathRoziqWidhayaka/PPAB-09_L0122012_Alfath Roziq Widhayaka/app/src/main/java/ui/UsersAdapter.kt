package ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.ppab_09_l0122012_alfathroziqwidhayaka.R
import com.squareup.picasso.Picasso
import response.UserResponse

class UsersAdapter (
    private val context: Context,
    private val data: ArrayList<UserResponse>
): RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvImg = view.findViewById<ImageView>(R.id.tvImg)
        val tvId = view.findViewById<TextView>(R.id.tvId)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
        val tvPlatform = view.findViewById<TextView>(R.id.tvPlatform)
        val tvPublisher = view.findViewById<TextView>(R.id.tvPublisher)
        val cvUser = view.findViewById<CardView>(R.id.cvUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_user, parent, false)

        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Picasso.get()
            .load(data.get(position).thumbnail)
            .into(holder.tvImg)

        holder.tvId.text = data.get(position).id.toString()
        holder.tvTitle.text = data.get(position).title
        holder.tvDescription.text = data.get(position).shortDescription
        holder.tvPlatform.text = data.get(position).platform
        holder.tvPublisher.text = data.get(position).publisher
        holder.cvUser.setOnClickListener {
            Toast.makeText(context, "" + data.get(position).title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: ArrayList<UserResponse>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}