package com.example.apilist.data

data class Character(
    val asin: String,
    val climate_pledge: Boolean,
    val is_amazon_choice: Boolean,
    val is_best_seller: Boolean,
    val is_prime: Boolean,
    val offers_count: Int,
    val product_delivery_info: String,
    val product_num_ratings: String,
    val product_original_price: String,
    val product_photo: String,
    val product_price: String,
    val product_star_rating: String,
    val product_stock_message: Any,
    val product_title: String,
    val product_url: String,
    val sales_volume: String
)