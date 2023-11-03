package com.auwfar.indonesiaku.domain.repositories

import com.auwfar.indonesiaku.domain.datasources.AreaDataSource
import com.auwfar.indonesiaku.network.model.ProvinceModel
import javax.inject.Inject

class AreaRepository @Inject constructor(private val areaDataSource: AreaDataSource) {
    suspend fun getProvinces(): List<ProvinceModel>? {
        return areaDataSource.getProvinces()
    }
}