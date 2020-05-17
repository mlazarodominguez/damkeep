package com.example.damkeep.api


import com.example.damkeep.api.response.LoginRequest
import com.example.damkeep.api.response.LoginResponse

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("auth/login")
    fun login(@Body data: LoginRequest): Call<LoginResponse>





}