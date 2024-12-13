package com.maxie.gootax_test.fragments.home.entities

data class PromoViewData(
    val id: Int,
    val promoPercentage: Int,
    val promoStatus: Boolean,
    val imgUri: String,
    val promoTitle: String,
    val weight: Int,
    val promoPrice: Int,
    val price: Int,
    val backgroundColor: String
)
