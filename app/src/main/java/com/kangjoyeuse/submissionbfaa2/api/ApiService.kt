package com.kangjoyeuse.submissionbfaa2.api

import com.kangjoyeuse.submissionbfaa2.model.EventResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("events")
    fun getEvents(@Query("active") active: Int): Call<EventResponse>
}