package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApiService


interface AmphibianRepository {
    suspend fun getAmphibians(): List<Amphibian>
}


class NetworkAmphibianRepository(
    private val apiService: AmphibianApiService
) : AmphibianRepository {
    override suspend fun getAmphibians() = apiService.getAmphibians()
}