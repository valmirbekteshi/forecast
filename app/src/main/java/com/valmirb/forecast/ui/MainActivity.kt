package com.valmirb.forecast.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.valmirb.forecast.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navcontroller: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //assign navigationcontroller from view
        navcontroller  = Navigation.findNavController(this,R.id.nav_host_fragment)
        //setup bottomnav with navigation
        bottom_nav.setupWithNavController(navcontroller)

        NavigationUI.setupActionBarWithNavController(this,navcontroller)

    }


    //onSupportNavigateUp is method that is used  to get you back to previous screen
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navcontroller,null)
    }
}
