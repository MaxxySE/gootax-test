package com.maxie.gootax_test.api

import com.maxie.gootax_test.fragments.home.entities.SearchViewData
import retrofit2.http.GET

interface ApiService {

    @GET("search")
    suspend fun getSearchData(): List<SearchViewData>

}