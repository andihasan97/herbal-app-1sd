package com.herbalapp

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import android.content.Intent
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import android.view.*

class ListHerbalAdapter(private val listHerbal: ArrayList<Herbal>) : RecyclerView.Adapter<ListHerbalAdapter.ListViewHolder>() {
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
		val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_herbal, parent, false)
		return ListViewHolder(view)
		
	}
	
	override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
		val herbal = listHerbal[position]
		
		Glide.with(holder.itemView.context)
			.load(herbal.photo)
			.apply(RequestOptions().override(55, 55))
			.into(holder.imgPhoto)
			
		holder.tvName.text = herbal.name
		holder.tvDetail.text = herbal.detail
		holder.imgPhoto.setImageResource(herbal.photo)
		holder.itemView.setOnClickListener {
			val intent = Intent(holder.itemView.context, DetailActivity::class.java)
			intent.putExtra("nama", listHerbal[position].name)
			intent.putExtra("detail", listHerbal[position].detail)
			intent.putExtra("photo", listHerbal[position].photo)
			
			holder.itemView.context.startActivity(intent)
		}
	}
	
	override fun getItemCount(): Int {
		return listHerbal.size
		
	}
	
	inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
		var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
		var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)	
	}	
}