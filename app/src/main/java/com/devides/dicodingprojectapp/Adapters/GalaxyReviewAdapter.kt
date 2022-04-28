package com.devides.dicodingprojectapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devides.dicodingprojectapp.Galaxy
import com.devides.dicodingprojectapp.R

class GalaxyReviewAdapter(private val listGalaxy: ArrayList<Galaxy>) : RecyclerView.Adapter<GalaxyReviewAdapter.GalaxyViewHolder>() {
    inner  class GalaxyViewHolder(galaxyItemView: View) : RecyclerView.ViewHolder(galaxyItemView) {
        var galaxyPhoto: ImageView = galaxyItemView.findViewById(R.id.galaxy_photo)
        var galaxyName: TextView = galaxyItemView.findViewById(R.id.galaxy_name)
        var galaxyDetail: TextView = galaxyItemView.findViewById(R.id.galaxy_detail)
        var galaxyFavorite: Button = galaxyItemView.findViewById(R.id.galaxy_favorite)
        var galaxyShare: Button = galaxyItemView.findViewById(R.id.galaxy_share)
    }

    override fun onCreateViewHolder(galaxyParent: ViewGroup, viewType: Int): GalaxyViewHolder {
        val galaxyView: View = LayoutInflater.from(galaxyParent.context).inflate(R.layout.galaxy_review, galaxyParent, false)
        return GalaxyViewHolder(galaxyView)
    }

    override fun onBindViewHolder(galaxyHolder: GalaxyViewHolder, positionGalaxy: Int) {
        val galaxy = listGalaxy[positionGalaxy]

        Glide.with(galaxyHolder.itemView.context)
            .load(galaxy.photoGalaxy)
            .apply(RequestOptions().override(300, 500))
            .into(galaxyHolder.galaxyPhoto)

        galaxyHolder.galaxyName.text = galaxy.nameGalaxy
        galaxyHolder.galaxyDetail.text = galaxy.detailGalaxy

        galaxyHolder.galaxyFavorite.setOnClickListener { Toast.makeText(galaxyHolder.itemView.context, "Kamu menambahkan ke Favorite " + listGalaxy[galaxyHolder.adapterPosition].nameGalaxy, Toast.LENGTH_SHORT).show()}
        galaxyHolder.galaxyShare.setOnClickListener { Toast.makeText(galaxyHolder.itemView.context, "Kamu telah Membagikan " + listGalaxy[galaxyHolder.adapterPosition].nameGalaxy, Toast.LENGTH_SHORT).show() }
        galaxyHolder.itemView.setOnClickListener { Toast.makeText(galaxyHolder.itemView.context, "Kamu Memilih " + listGalaxy[galaxyHolder.adapterPosition].nameGalaxy, Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int {
        return  listGalaxy.size
    }
}