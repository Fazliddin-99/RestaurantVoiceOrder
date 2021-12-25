package com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.fazliddin.restaurantreservationmilliyintellekt.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.foodsList.adapter = MealsListAdapter()
        binding.restaurantsRecyclerView.adapter = RestaurantsListAdapter()
        return binding.root
    }

}