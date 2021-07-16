package com.bangik.packclese.model.response.rajaongkir

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KotaTujuanResponse(
    @Expose
    @SerializedName("page")
    val page: Int,
    @Expose
    @SerializedName("data")
    val `data`: List<DataKotaTujuan>
)