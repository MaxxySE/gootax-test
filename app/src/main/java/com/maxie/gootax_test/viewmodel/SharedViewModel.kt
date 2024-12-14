package com.maxie.gootax_test.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    private val _address = MutableLiveData<String>()
    val address: LiveData<String> get() = _address

    init {
        _address.value = sharedPreferences.getString("address_key", "")
    }

    fun setAddress(data: String){
        sharedPreferences.edit().putString("address_key", data).apply()
        _address.value = data
    }

}