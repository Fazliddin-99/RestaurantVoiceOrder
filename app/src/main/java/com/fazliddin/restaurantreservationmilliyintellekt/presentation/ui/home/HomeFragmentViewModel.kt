package com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fazliddin.restaurantreservationmilliyintellekt.data.Repository
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.Meal
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.Restaurant

class HomeFragmentViewModel: ViewModel() {
    private val repository = Repository()
    val meals: LiveData<List<Meal>> = MutableLiveData(repository.getMeals())
    val restaurants: LiveData<List<Restaurant>> = MutableLiveData(repository.getRestaurants())
}