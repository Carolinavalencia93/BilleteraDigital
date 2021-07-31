package com.example.billeteradigital.api

import retrofit2.Retrofit

object ApiService {
    private val TAG = "--ApiService"

    private const val BASE_URL = "https://extendsclass.com/mock/rest/d901e7950d794599323f872d6ce5fac6/"

    fun loginApiCall() = Retrofit.Builder()
        .baseUrl(BASE_URL)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(ApiWorker.gsonConverter)
        .client(ApiWorker.client)
        .build()
        .create(ApiList::class.java)!!
}