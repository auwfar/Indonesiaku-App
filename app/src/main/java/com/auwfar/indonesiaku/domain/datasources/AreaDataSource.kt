package com.auwfar.indonesiaku.domain.datasources

import com.auwfar.indonesiaku.network.ApiService
import com.auwfar.indonesiaku.network.model.ProvinceModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class AreaDataSource @Inject constructor(
    private val apiService: ApiService
) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    suspend fun getProvinces(): List<ProvinceModel>? {
        return withContext(coroutineContext) {
            try {
                apiService.getProvinces()
            } catch (e: Exception) {
                listOf()
            }
        }
    }
}