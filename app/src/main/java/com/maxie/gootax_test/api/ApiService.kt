package com.maxie.gootax_test.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("suggestions/api/4_1/rs/suggest/address")
    suspend fun suggestAddress(
        @Header("Authorization") token: String,
        @Body query: Map<String, String>
    ): Response<ResponseBody>

}