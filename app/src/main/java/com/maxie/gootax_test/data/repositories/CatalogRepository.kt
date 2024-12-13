package com.maxie.gootax_test.data.repositories

import com.maxie.gootax_test.fragments.home.entities.CatalogViewData

class CatalogRepository {

    fun fetchCatalogData(): List<CatalogViewData> {
        return listOf(
            CatalogViewData(
                id = 1,
                imgUri = "https://i.ibb.co/zPzC3Bj/cat-ph.png",
                title = "Наборы",
                backgroundColor = "#FFC1B6"
            ),
            CatalogViewData(
                id = 2,
                imgUri = "https://i.ibb.co/0MM6nMy/cat-2.png",
                title = "Пицца",
                backgroundColor = "#FFE1AD"
            ),
            CatalogViewData(
                id = 3,
                imgUri = "https://i.ibb.co/7KHhL0Q/cat-3.png",
                title = "Паста",
                backgroundColor = "#BAB892"
            ),
            CatalogViewData(
                id = 4,
                imgUri = "https://i.ibb.co/W6vcL1C/promo-2.png",
                title = "Ризотто",
                backgroundColor = "#C4D3CE"
            ),
            CatalogViewData(
                id = 5,
                imgUri = "https://i.ibb.co/025JS86/promo-ph.png",
                title = "Салаты",
                backgroundColor = "#B9C4C8"
            ),
            CatalogViewData(
                id = 6,
                imgUri = "https://i.ibb.co/f1PSFsV/cat-6.png",
                title = "Полу\nфабрикаты",
                backgroundColor = "#A3AE9D"
            ),
            CatalogViewData(
                id = 7,
                imgUri = "https://i.ibb.co/WvDZR9r/cat-7.png",
                title = "Десерты",
                backgroundColor = "#FFE6B6"
            ),
            CatalogViewData(
                id = 8,
                imgUri = "https://i.ibb.co/CPxCtmW/cat-8.png",
                title = "Добавки\nк блюдам",
                backgroundColor = "#D3C4C4"
            ),
            CatalogViewData(
                id = 9,
                imgUri = "https://i.ibb.co/SnrSXhk/cat-9.png",
                title = "Напитки",
                backgroundColor = "#FFD4AD"
            ),
        )
    }

}