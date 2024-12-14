package com.maxie.gootax_test.fragments.home.modal.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.maxie.gootax_test.api.ApiService
import com.maxie.gootax_test.data.repositories.SearchRepository
import com.maxie.gootax_test.fragments.home.entities.SearchViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _searchResults = MutableLiveData<List<SearchViewData>>()
    val searchResults: LiveData<List<SearchViewData>> get() = _searchResults

    fun getSuggestedResponse(apiService: ApiService, query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val jsonString = SearchRepository().suggestAddress(apiService, query)
            val searchViewDataList = parseJsonToSearchViewData(jsonString)
            _searchResults.postValue(searchViewDataList)
        }
    }

    private fun parseJsonToSearchViewData(jsonString: String): List<SearchViewData> {
        val gson = Gson()
        val jsonObject = gson.fromJson(jsonString, JsonObject::class.java)
        val suggestions = jsonObject["suggestions"].asJsonArray

        val result = mutableSetOf<SearchViewData>()

        for (suggestion in suggestions) {
            val data = suggestion.asJsonObject["data"].asJsonObject

            val street = data["street"]?.takeIf { !it.isJsonNull }?.asString
            val streetType = data["street_type"]?.takeIf { !it.isJsonNull }?.asString
            val house = data["house"]?.takeIf { !it.isJsonNull }?.asString
            val city = data["city"]?.takeIf { !it.isJsonNull }?.asString
            val region = data["region"]?.takeIf { !it.isJsonNull }?.asString
            val regionTypeFull = data["region_type_full"]?.takeIf { !it.isJsonNull }?.asString
            val country = data["country"]?.takeIf { !it.isJsonNull }?.asString

            if (!street.isNullOrEmpty() && !city.isNullOrEmpty() && !streetType.isNullOrEmpty() &&
                !region.isNullOrEmpty() && !regionTypeFull.isNullOrEmpty() && !country.isNullOrEmpty()
            ) {
                val searchViewData = SearchViewData(
                    street = street,
                    street_type = streetType,
                    house = house ?: "",
                    city = city,
                    region = region,
                    region_type_full = regionTypeFull,
                    country = country
                )
                result.add(searchViewData)
            }
        }
        return result.toList()
    }
}