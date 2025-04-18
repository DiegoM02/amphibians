package com.example.amphibians.data

import com.example.amphibians.network.AmphibianApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


interface AppContainer{
    val amphibianRepository: AmphibianRepository
}

class DefaultAppContainer: AppContainer{
    private val urlBase =  "https://android-kotlin-fun-mars-server.appspot.com/"

    private val  retrofit: Retrofit = Retrofit.Builder().
    addConverterFactory(Json.asConverterFactory("application/json".toMediaType())).
    baseUrl(urlBase)
        .build()

    private val retrofiService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }
    override val amphibianRepository: AmphibianRepository by lazy {
        NetworkAmphibianRepository(retrofiService)
    }



}