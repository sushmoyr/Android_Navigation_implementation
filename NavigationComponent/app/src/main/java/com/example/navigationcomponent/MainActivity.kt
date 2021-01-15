package com.example.navigationcomponent

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationcomponent.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    //Global Init
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var listener: NavController.OnDestinationChangedListener

    private val _binding:ActivityMainBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.fragment)
        drawerLayout = binding.drawerLayoutView
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        navigationView = binding.navigationView //Globally initialized

        navigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
        
        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id == R.id.firstFragment)
            {
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.design_default_color_primary)))
            }
            else if(destination.id == R.id.secondFragment)
            {
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.design_default_color_secondary)))
            }
        }
        

    }
    //Override them to add or remove listeners (must)
    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }
    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(listener)
    }

    override fun onSupportNavigateUp(): Boolean {  //Function needed for navigation
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}