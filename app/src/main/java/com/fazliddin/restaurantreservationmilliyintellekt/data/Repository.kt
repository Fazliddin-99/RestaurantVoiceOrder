package com.fazliddin.restaurantreservationmilliyintellekt.data

import com.fazliddin.restaurantreservationmilliyintellekt.data.models.Meal
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.Restaurant

class Repository {

    fun getRestaurants(): List<Restaurant> {
        val restaurant1 = Restaurant(
            "Besh qozon",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/restoran%2Fbesh_qozon.jpg?alt=media&token=f1ee35ae-08a1-4f29-a7d6-0710d67a3d86",
            "Ko'kcha darvoza, 345, Toshkent"
        )
        val restaurant2 = Restaurant(
            "Kamolon",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/restoran%2Fkamolon.jpg?alt=media&token=d0f4900d-0c97-4791-a65f-129c20afdfa9",
            "Bunyodkor ko'chasi 6-uy, Toshkent"
        )
        val restaurant3 = Restaurant(
            "Tarnov boshi",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/restoran%2Ftarnov.jpg?alt=media&token=03a45107-43a6-4ce4-b521-eafa4289a0e5",
            "Shayhontohur tumani, Sebzor ko'chasi 5-uy"
        )
        val restaurant4 = Restaurant(
            "Kish-mish",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/restoran%2Fkish.jpeg?alt=media&token=1a2f2073-734b-46d9-a6e8-0b092cbbaa6d",
            "Mirzo Ulug'bek tumani, Ergashev ko'chasi 124"
        )
        val restaurant5 = Restaurant(
            "Rayhon",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/restoran%2Frayhon-milliyy-taomlar.jpg?alt=media&token=765cffd7-4772-40a5-9c24-e5ba987f2431",
            "Shayhontohur tumani, Zulfiyaxonim ko'chasi 214"
        )

        return listOf(restaurant1, restaurant2, restaurant3, restaurant4, restaurant5)
    }

    fun getMeals(): List<Meal> {
        val meal1 = Meal(
            "Osh",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/osh.jpg?alt=media&token=8acde39c-de1a-43dd-9e41-e82de9b80061",
            "Besh qozon"
        )
        val meal2 = Meal(
            "Somsa",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/samsa.jpg?alt=media&token=dc22183c-bf7c-4ab4-9186-085433cc4a52",
            "Kamolon"
        )
        val meal3 = Meal(
            "Norin",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/norin.jpg?alt=media&token=547f303d-2e91-4a7f-b0e9-58f7b94efe27",
            "Tarnov boshi"
        )
        val meal4 = Meal(
            "Manti",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/manti.jpg?alt=media&token=80b9d57c-9826-4fa1-8fa5-95d96a34634b",
            "Kishmish"
        )
        val meal5 = Meal(
            "Chuchvara",
            "https://firebasestorage.googleapis.com/v0/b/milliy-intellekt.appspot.com/o/chuchvara.jpg?alt=media&token=07be8d38-1dd4-4ec5-8ad0-0ad60bb6e46f",
            "Rayhon"
        )

        return listOf(meal1, meal2, meal3, meal4, meal5)
    }

}