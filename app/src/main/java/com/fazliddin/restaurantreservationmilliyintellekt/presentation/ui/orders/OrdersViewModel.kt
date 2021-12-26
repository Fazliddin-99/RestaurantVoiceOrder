package com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.OrderListItem

class OrdersViewModel(ordersList: List<OrderListItem>?) : ViewModel() {
    val orders: LiveData<List<OrderListItem>?> = MutableLiveData(ordersList)
    var totalSum: Int = 0

    init {
        ordersList?.forEach {
            totalSum += it.sum
        }
    }
}

