package com.devides.dicodingprojectapp.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devides.dicodingprojectapp.Activities.DetailGalaxyActivity
import com.devides.dicodingprojectapp.Galaxy
import com.devides.dicodingprojectapp.R

class GalaxyDetailAdapter(val listGalaxy: ArrayList<Galaxy>) : RecyclerView.Adapter<GalaxyDetailAdapter.GalaxyDetailHolder>() {
    class GalaxyDetailHolder(galaxyItemView: View)  : RecyclerView.ViewHolder(galaxyItemView) {
        var galaxyName: TextView = galaxyItemView.findViewById(R.id.galaxy_name)
        var galaxyInventor: TextView = galaxyItemView.findViewById(R.id.galaxy_inventor)
        var galaxyPhoto: ImageView = galaxyItemView.findViewById(R.id.galaxy_photo)
    }

    override fun onCreateViewHolder(galaxyViewGroup: ViewGroup, viewType: Int): GalaxyDetailHolder {
        val galaxyView: View = LayoutInflater.from(galaxyViewGroup.context).inflate(R.layout.galaxy_dashboard_detail, galaxyViewGroup, false)
        return GalaxyDetailHolder(galaxyView)
    }

    override fun onBindViewHolder(holderGalaxy: GalaxyDetailHolder, positionGalaxy: Int) {
        val (name, inventor, photo, information, detail) = listGalaxy[positionGalaxy]

        Glide.with(holderGalaxy.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holderGalaxy.galaxyPhoto)

        holderGalaxy.galaxyName.text = name
        holderGalaxy.galaxyInventor.text = inventor

        val contextGalaxy = holderGalaxy.itemView.context

        holderGalaxy.itemView.setOnClickListener {
            val moveDetailGalaxy = Intent(contextGalaxy, DetailGalaxyActivity::class.java)
            moveDetailGalaxy.putExtra(DetailGalaxyActivity.EXTRA_NAME_GALAXY, name)
            moveDetailGalaxy.putExtra(DetailGalaxyActivity.EXTRA_INVENTOR_GALAXY, inventor)
            moveDetailGalaxy.putExtra(DetailGalaxyActivity.EXTRA_PHOTO_GALAXY, photo)
            moveDetailGalaxy.putExtra(DetailGalaxyActivity.EXTRA_INFORMATION_GALAXY, information)
            moveDetailGalaxy.putExtra(DetailGalaxyActivity.EXTRA_DETAIL_GALAXY, detail)
            contextGalaxy.startActivity(moveDetailGalaxy)
        }
    }

    override fun getItemCount(): Int {
       return listGalaxy.size
    }

}