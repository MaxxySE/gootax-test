package com.maxie.gootax_test.fragments.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

}