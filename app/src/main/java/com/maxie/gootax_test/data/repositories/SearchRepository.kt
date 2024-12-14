package com.maxie.gootax_test.data.repositories

import android.content.ContentValues
import android.util.Log
import com.maxie.gootax_test.api.ApiService
import com.maxie.gootax_test.data.constants.SearchConstants
import retrofit2.HttpException

class SearchRepository {

    suspend fun suggestAddress(apiService: ApiService, query: String) : String {

        val requestBody = mapOf("query" to query)

        return try {
            val response = apiService.suggestAddress(SearchConstants.getToken(), requestBody)
            response.body()?.string() ?: "Empty"
        } catch (e: HttpException) {
            Log.e(ContentValues.TAG, "$e: Server error")
            ""
        }

    }

}