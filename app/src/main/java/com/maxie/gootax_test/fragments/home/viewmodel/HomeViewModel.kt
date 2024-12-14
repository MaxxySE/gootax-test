package com.maxie.gootax_test.fragments.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maxie.gootax_test.data.repositories.BannerRepository
import com.maxie.gootax_test.data.repositories.CatalogRepository
import com.maxie.gootax_test.data.repositories.PromoRepository
import com.maxie.gootax_test.data.repositories.RecommendedRepository
import com.maxie.gootax_test.fragments.home.entities.BannerViewData
import com.maxie.gootax_test.fragments.home.entities.CatalogViewData
import com.maxie.gootax_test.fragments.home.entities.PromoViewData
import com.maxie.gootax_test.fragments.home.entities.RecommendedViewData

class HomeViewModel: ViewModel() {

    private var amount = 0

    private val _goodsAmount = MutableLiveData<Int>()
    val goodsAmount: LiveData<Int> = _goodsAmount

    fun addGoodsAmount() {
        amount += 1
        _goodsAmount.value = amount
    }

    fun removeGoodsAmount() {
        amount -= 1
        _goodsAmount.value = amount
    }

    private val _bannerList = MutableLiveData<List<BannerViewData>>()
    val bannerList: LiveData<List<BannerViewData>> = _bannerList

    fun getBannersData() {
        _bannerList.value = BannerRepository().fetchBannerData()
    }

    private val _catalogList = MutableLiveData<List<CatalogViewData>>()
    val catalogList: LiveData<List<CatalogViewData>> = _catalogList

    fun getCatalogData() {
        _catalogList.value = CatalogRepository().fetchCatalogData()
    }

    private val _promoList = MutableLiveData<List<PromoViewData>>()
    val promoList: LiveData<List<PromoViewData>> = _promoList

    fun getPromoData() {
        _promoList.value = PromoRepository().fetchPromoData()
    }

    private val _recommendedList = MutableLiveData<List<RecommendedViewData>>()
    val recommendedList: LiveData<List<RecommendedViewData>> = _recommendedList

    fun getRecommendedData() {
        _recommendedList.value = RecommendedRepository().fetchRecommendedData()
    }

}