package com.fazliddin.restaurantreservationmilliyintellekt.data.models

import android.os.Parcelable
import com.fazliddin.restaurantreservationmilliyintellekt.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderListItem(
    val meal: String = "",
    val quantity: Int = 0,
    val imgId: Int = R.drawable.ic_broken_image,
    val price: Int = 30000,
    val sum: Int = quantity * price
) : Parcelable