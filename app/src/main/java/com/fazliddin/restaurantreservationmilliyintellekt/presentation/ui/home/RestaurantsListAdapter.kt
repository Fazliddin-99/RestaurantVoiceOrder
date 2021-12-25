package com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.Restaurant
import com.fazliddin.restaurantreservationmilliyintellekt.databinding.RestaurantsListItemBinding

class RestaurantsListAdapter : ListAdapter<Restaurant, RestaurantsListAdapter.RestaurantVH>(
    object : DiffUtil.ItemCallback<Restaurant>() {
        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
            oldItem == newItem

        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
            oldItem.name == newItem.name

    }) {

    class RestaurantVH(private val binding: RestaurantsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Restaurant) {
            binding.restaurant = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RestaurantsListItemBinding.inflate(inflater, parent, false)

        return RestaurantVH(binding)
    }

    override fun onBindViewHolder(holder: RestaurantVH, position: Int) {
        holder.bind(getItem(position))
    }

}