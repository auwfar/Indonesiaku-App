package com.auwfar.indonesiaku.network

import com.auwfar.indonesiaku.network.model.ProvinceModel
import retrofit2.http.*

interface ApiService {
    @GET("provinces")
    suspend fun getProvinces(): List<ProvinceModel>?
}