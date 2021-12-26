package com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.OrderListItem
import java.lang.IllegalArgumentException

class OrdersViewModelFactory(private val orders: List<OrderListItem>?): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrdersViewModel::class.java))
            return OrdersViewModel(orders) as T

        throw IllegalArgumentException("error assigning orders view model")
    }
}