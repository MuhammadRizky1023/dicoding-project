package com.devides.dicodingprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devides.dicodingprojectapp.Activities.AboutProfileActivity
import com.devides.dicodingprojectapp.Adapters.GalaxyBackgroundAdapter
import com.devides.dicodingprojectapp.Adapters.GalaxyDetailAdapter
import com.devides.dicodingprojectapp.Adapters.GalaxyReviewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvGalaxies: RecyclerView
    private var list: ArrayList<Galaxy> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBarGalaxy = supportActionBar
        actionBarGalaxy!!.title = "Galaxy"

        rvGalaxies = findViewById(R.id.rv_galaxy)
        rvGalaxies.setHasFixedSize(true)

        list.addAll(GalaxyData.listGalaxyData)
        showRecyclerGalaxyHomeDetail()
    }

    private fun showRecyclerGalaxyHomeDetail(){
        rvGalaxies.layoutManager = LinearLayoutManager(this)
        val galaxyHomeAdapter = GalaxyDetailAdapter(list)
        rvGalaxies.adapter = galaxyHomeAdapter
    }


    private fun  showRecyclerGalaxyBackground(){
        rvGalaxies.layoutManager = GridLayoutManager(this, 2)
        val galaxyBackgroundAdapter = GalaxyBackgroundAdapter(list)
        rvGalaxies.adapter =  galaxyBackgroundAdapter

        galaxyBackgroundAdapter.setOnItemClickCallback(object: GalaxyBackgroundAdapter.OnItemGalaxyClickCallback{
            override fun onItemGalaxyClicked(galaxy: Galaxy) {
                showSelectedGalaxy(galaxy)
            }
        })
    }

    private fun showRecyclerGalaxyReview(){
        rvGalaxies.layoutManager = LinearLayoutManager(this)
        val  galaxyReviewAdapter = GalaxyReviewAdapter(list)
        rvGalaxies.adapter = galaxyReviewAdapter
    }

    private fun showSelectedGalaxy(galaxy: Galaxy){
        Toast.makeText(this, "Kamu Memilih " + galaxy.nameGalaxy, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun  setMode(selectedMode: Int){
        when(selectedMode){
            R.id.action_home -> {
                showRecyclerGalaxyHomeDetail()
            }
            R.id.action_background -> {
                showRecyclerGalaxyBackground()
            }
            R.id.action_review -> {
                showRecyclerGalaxyReview()
            }
            R.id.action_profile -> {
                val aboutProfile = Intent(this@MainActivity, AboutProfileActivity::class.java)
                startActivity(aboutProfile)
            }
        }

    }

}
