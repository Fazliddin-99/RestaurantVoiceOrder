package com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fazliddin.restaurantreservationmilliyintellekt.databinding.FragmentOrdersBinding

class OrdersFragment : Fragment() {

    private lateinit var viewModel: OrdersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOrdersBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        try {
            val args = OrdersFragmentArgs.fromBundle(requireArguments())
            viewModel = ViewModelProvider(
                this,
                OrdersViewModelFactory(args.orders?.toList())
            ).get(OrdersViewModel::class.java)

            binding.viewModel = viewModel

        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding.ordersList.adapter = OrdersListAdapter()

        return binding.root
    }
}