package com.maxie.gootax_test.data.repositories

import com.maxie.gootax_test.fragments.home.entities.BannerViewData
import com.maxie.gootax_test.fragments.home.entities.RecommendedViewData

class BannerRepository {

    fun fetchBannerData(): List<BannerViewData> {
        return listOf(
            BannerViewData(
                id = 1,
                imgUri = "https://i.ibb.co/B2ZVBbk/banner-1.png",
                title = "Открытие"),
            BannerViewData(
                id = 2,
                imgUri = "https://i.ibb.co/VLnBKcw/banner-2.png",
                title = "Закрытие"),
            BannerViewData(
                id = 3,
                imgUri = "https://i.ibb.co/gTW98NH/banner-3.png",
                title = "Новый год"),
            BannerViewData(
                id = 4,
                imgUri = "https://i.ibb.co/x1n0tkG/banner-4.png",
                title = "Салаты"),
            BannerViewData(
                id = 5,
                imgUri = "ttps://i.ibb.co/B2ZVBbk/banner-1.png",
                title = "Открытие"),
            BannerViewData(
                id = 6,
                imgUri = "https://i.ibb.co/VLnBKcw/banner-2.png",
                title = "Закрытие"),
            BannerViewData(
                id = 7,
                imgUri = "https://i.ibb.co/gTW98NH/banner-3.png",
                title = "Новый год"),
        )
    }

}