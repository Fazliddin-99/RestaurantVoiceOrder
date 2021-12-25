package com.fazliddin.restaurantreservationmilliyintellekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fazliddin.restaurantreservationmilliyintellekt.databinding.ActivityMainBinding
import com.fazliddin.restaurantreservationmilliyintellekt.presentation.common.CurvedBottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var curvedBottomNavigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        curvedBottomNavigationView = binding.bottomNavigation
        curvedBottomNavigationView.inflateMenu(R.menu.bottom_app_bar);
    }
}