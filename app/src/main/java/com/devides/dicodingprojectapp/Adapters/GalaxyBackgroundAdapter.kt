package com.devides.dicodingprojectapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devides.dicodingprojectapp.Galaxy
import com.devides.dicodingprojectapp.R

class GalaxyBackgroundAdapter(val  listGalaxy: ArrayList<Galaxy>) : RecyclerView.Adapter<GalaxyBackgroundAdapter.GridGalaxyViewHolder>() {
    private lateinit var onItemGalaxyClickCallback: OnItemGalaxyClickCallback

    interface OnItemGalaxyClickCallback {
        fun onItemGalaxyClicked(galaxy: Galaxy)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemGalaxyClickCallback) {
        this.onItemGalaxyClickCallback = onItemClickCallback
    }

    inner class GridGalaxyViewHolder(itemGalaxyView: View) : RecyclerView.ViewHolder(itemGalaxyView) {
       var imgGalaxyPhoto : ImageView = itemGalaxyView.findViewById(R.id.galaxy_photo)
    }

    override fun onCreateViewHolder(viewGalaxyGroup: ViewGroup, viewType: Int): GridGalaxyViewHolder {
        val  galaxyView: View = LayoutInflater.from(viewGalaxyGroup.context).inflate(R.layout.galaxy_backrground, viewGalaxyGroup, false)
        return GridGalaxyViewHolder(galaxyView)
    }

    override fun onBindViewHolder(holderGalaxy: GridGalaxyViewHolder, position: Int) {
        Glide.with(holderGalaxy.itemView.context)
            .load(listGalaxy[position].photoGalaxy)
            .apply(RequestOptions().override(350, 550))
            .into(holderGalaxy.imgGalaxyPhoto)

        holderGalaxy.itemView.setOnClickListener { onItemGalaxyClickCallback.onItemGalaxyClicked(listGalaxy[holderGalaxy.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return  listGalaxy.size
    }
}
