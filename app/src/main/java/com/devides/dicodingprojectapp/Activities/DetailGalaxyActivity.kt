package com.devides.dicodingprojectapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devides.dicodingprojectapp.R

class DetailGalaxyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.galaxy_detail)

        val actionBarDetail = supportActionBar
        actionBarDetail!!.title = "Detail Galaxy"
        actionBarDetail.setDisplayHomeAsUpEnabled(true)

        val galaxyName: TextView = findViewById(R.id.galaxy_name)
        val galaxyPhoto: ImageView = findViewById(R.id.galaxy_photo)
        val galaxyInformation: TextView = findViewById(R.id.galaxy_information)
        val  galaxyDetail: TextView = findViewById(R.id.galaxy_detail)
        val galaxyLike: Button = findViewById(R.id.galaxy_like)
        val galaxyInventor: TextView = findViewById(R.id.galaxy_inventor)

        val gName = intent.getStringExtra(EXTRA_NAME_GALAXY)
        val gPhoto = intent.getIntExtra(EXTRA_PHOTO_GALAXY, 0)
        val gInformation = intent.getStringExtra(EXTRA_INFORMATION_GALAXY)
        val gDetail = intent.getStringExtra(EXTRA_DETAIL_GALAXY)
        val gInventor = intent.getStringExtra(EXTRA_INVENTOR_GALAXY)

        galaxyName.text = gName
        Glide.with(this)
            .load(gPhoto)
            .apply(RequestOptions())
            .into(galaxyPhoto)
        galaxyInformation.text = gInformation
        galaxyDetail.text = gDetail
        galaxyInventor.text = gInventor

        galaxyLike.setOnClickListener {
            Toast.makeText(this@DetailGalaxyActivity, "kamu telah menyukai galaksi ini", Toast.LENGTH_SHORT).show()
        }
    }
    companion object{
        const val EXTRA_PHOTO_GALAXY = "extra_photo_galaxy"
        const val EXTRA_NAME_GALAXY = "extra_name_galaxy"
        const val EXTRA_INFORMATION_GALAXY = "extra_information_galaxy"
        const val EXTRA_DETAIL_GALAXY = "extra_detail_galaxy"
        const val EXTRA_INVENTOR_GALAXY = "extra_inventor_galaxy"
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}
