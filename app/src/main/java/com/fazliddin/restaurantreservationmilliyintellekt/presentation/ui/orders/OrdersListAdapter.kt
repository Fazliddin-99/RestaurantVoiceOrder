package com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.OrderListItem
import com.fazliddin.restaurantreservationmilliyintellekt.databinding.OrdersItemBinding

class OrdersListAdapter : ListAdapter<OrderListItem, OrdersListAdapter.OrdersListVH>(
    object : DiffUtil.ItemCallback<OrderListItem>() {
        override fun areContentsTheSame(oldItem: OrderListItem, newItem: OrderListItem): Boolean =
            oldItem == newItem

        override fun areItemsTheSame(oldItem: OrderListItem, newItem: OrderListItem): Boolean =
            oldItem.meal == newItem.meal

    }) {

    class OrdersListVH(private val binding: OrdersItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OrderListItem) {
            binding.order = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersListVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OrdersItemBinding.inflate(inflater, parent, false)

        return OrdersListVH(binding)
    }

    override fun onBindViewHolder(holder: OrdersListVH, position: Int) {
        holder.bind(getItem(position))
    }

}