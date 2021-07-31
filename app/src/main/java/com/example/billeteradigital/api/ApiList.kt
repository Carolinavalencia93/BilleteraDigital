package com.example.billeteradigital.api

import com.example.billeteradigital.SigninRequest
import com.example.billeteradigital.SigninResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiList {


    //TODO : Login User
    @POST("login")
    fun doLogin(
        @Body signinRequest: SigninRequest
    ): Call<SigninResponse> // body data



}