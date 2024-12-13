package com.maxie.gootax_test.data.repositories

import com.maxie.gootax_test.fragments.home.entities.PromoViewData

class PromoRepository {

    fun fetchPromoData() : List<PromoViewData> {
        return listOf(
            PromoViewData(
                id = 1,
                promoPercentage = 35,
                promoStatus = true,
                imgUri = "https://i.ibb.co/025JS86/promo-ph.png",
                promoTitle = "Черные спагетти с морепродуктам (большая порция) ",
                weight = 230,
                promoPrice = 1000,
                price = 650,
                backgroundColor = "#F4F4F4"
            ),
            PromoViewData(
                id = 2,
                promoPercentage = 25,
                promoStatus = false,
                imgUri = "https://i.ibb.co/W6vcL1C/promo-2.png",
                promoTitle = "Казаречче с индейкой и томатами ",
                weight = 230,
                promoPrice = 360,
                price = 200,
                backgroundColor = "#F4F4F4"
            ),
            PromoViewData(
                id = 3,
                promoPercentage = 35,
                promoStatus = true,
                imgUri = "https://i.ibb.co/Zx7wPrL/promo-3.png",
                promoTitle = "Равиоли с грибами",
                weight = 230,
                promoPrice = 1360,
                price = 1200,
                backgroundColor = "#F4F4F4"
            ),
            PromoViewData(
                id = 4,
                promoPercentage = 15,
                promoStatus = true,
                imgUri = "https://i.ibb.co/025JS86/promo-ph.png",
                promoTitle = "Очень длинное название блюда, которое явно не вместится в это вью, просто для теста",
                weight = 230,
                promoPrice = 1000,
                price = 650,
                backgroundColor = "#F4F4F4"
            ),
            PromoViewData(
                id = 5,
                promoPercentage = 35,
                promoStatus = false,
                imgUri = "https://i.ibb.co/W6vcL1C/promo-2.png",
                promoTitle = "Картошка запеченная в бетонном блоке",
                weight = 240,
                promoPrice = 1000,
                price = 650,
                backgroundColor = "#F4F4F4"
            ),
            PromoViewData(
                id = 6,
                promoPercentage = 5,
                promoStatus = true,
                imgUri = "https://i.ibb.co/Zx7wPrL/promo-3.png",
                promoTitle = "Гвозди под терияки соусом в кляре",
                weight = 230,
                promoPrice = 200,
                price = 100,
                backgroundColor = "#F4F4F4"
            ),
            PromoViewData(
                id = 7,
                promoPercentage = 65,
                promoStatus = false,
                imgUri = "https://i.ibb.co/025JS86/promo-ph.png",
                promoTitle = "Суп с особым соусом",
                weight = 130,
                promoPrice = 1000,
                price = 150,
                backgroundColor = "#F4F4F4"
            ),
        )
    }

}