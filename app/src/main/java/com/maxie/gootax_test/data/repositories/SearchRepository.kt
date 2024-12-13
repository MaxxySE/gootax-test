package com.maxie.gootax_test.data.repositories

import com.maxie.gootax_test.api.ApiService
import com.maxie.gootax_test.fragments.home.entities.SearchViewData

class SearchRepository(private val apiService: ApiService) {

    suspend fun fetchSearchData(): List<SearchViewData> {
        return apiService.getSearchData()
    }

}