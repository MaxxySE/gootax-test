package com.maxie.gootax_test.data.repositories

import com.maxie.gootax_test.fragments.home.entities.RecommendedViewData

class RecommendedRepository {

    fun fetchRecommendedData(): List<RecommendedViewData> {
        return listOf(
            RecommendedViewData(
                id = 1,
                imgUri = "https://i.ibb.co/9NMVtdj/rec-ph.png",
                title = "Летний пикник"),
            RecommendedViewData(
                id = 2,
                imgUri = "https://i.ibb.co/zn89sZB/rec-2.png",
                title = "Летний обед"),
            RecommendedViewData(
                id = 3,
                imgUri = "https://i.ibb.co/d40hJfP/rec-3.png",
                title = "На завтрак"),
            RecommendedViewData(
                id = 4,
                imgUri = "https://i.ibb.co/25qBYbL/rec-4.png",
                title = "На ужин"),
            RecommendedViewData(
                id = 5,
                imgUri = "https://i.ibb.co/9NMVtdj/rec-ph.png",
                title = "Ко сну"),
            RecommendedViewData(
                id = 6,
                imgUri = "https://i.ibb.co/zn89sZB/rec-2.png",
                title = "Салатик"),
            RecommendedViewData(
                id = 7,
                imgUri = "https://i.ibb.co/d40hJfP/rec-3.png",
                title = "Полдник"),
        )
    }

}