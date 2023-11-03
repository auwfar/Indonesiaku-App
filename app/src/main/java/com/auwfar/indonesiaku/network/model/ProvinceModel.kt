package com.auwfar.indonesiaku.network.model

import com.google.gson.annotations.SerializedName

data class ProvinceModel(
    @SerializedName("name")
    val name: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("website_url")
    val websiteUrl: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("logo_url")
    val logoUrl: String?,
    @SerializedName("lat_long")
    val latLong: String?,
)