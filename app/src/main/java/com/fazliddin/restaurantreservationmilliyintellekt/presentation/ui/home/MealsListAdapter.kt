package com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.Meal
import com.fazliddin.restaurantreservationmilliyintellekt.databinding.FoodListItemBinding

class MealsListAdapter : ListAdapter<Meal, MealsListAdapter.MealVH>(
    object : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal) = oldItem == newItem
    }) {

    class MealVH(private val binding: FoodListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Meal) {
            binding.meal = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FoodListItemBinding.inflate(inflater, parent, false)

        return MealVH(binding)
    }

    override fun onBindViewHolder(holder: MealVH, position: Int) {
        holder.bind(getItem(position))
    }

}