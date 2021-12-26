package com.fazliddin.restaurantreservationmilliyintellekt.domain

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fazliddin.restaurantreservationmilliyintellekt.R
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.Meal
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.OrderListItem
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.Restaurant
import com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.home.MealsListAdapter
import com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.home.RestaurantsListAdapter
import com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.orders.OrdersListAdapter

@BindingAdapter("mealsListData")
fun bindMealsListData(recyclerView: RecyclerView, data: List<Meal>?) {
    val adapter = recyclerView.adapter as MealsListAdapter
    adapter.submitList(data)
}

@BindingAdapter("restaurantsListData")
fun bindFurnitureListData(recyclerView: RecyclerView, data: List<Restaurant>?) {
    val adapter = recyclerView.adapter as RestaurantsListAdapter
    adapter.submitList(data)
}

@BindingAdapter("ordersListData")
fun bindOrdersListData(recyclerView: RecyclerView, data: List<OrderListItem>?) {
    val adapter = recyclerView.adapter as OrdersListAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Glide
        .with(view.context)
        .load(url)
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_broken_image)
        .into(view)
}