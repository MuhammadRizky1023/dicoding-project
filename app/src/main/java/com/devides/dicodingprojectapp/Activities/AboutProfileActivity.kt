package com.devides.dicodingprojectapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devides.dicodingprojectapp.R

class AboutProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_profile)

       val actionBarProfile = supportActionBar
        actionBarProfile!!.title = "AboutProfile"
        actionBarProfile.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}