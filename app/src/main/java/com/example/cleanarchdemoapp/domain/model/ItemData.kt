package com.example.cleanarchdemoapp.domain.model

import com.google.gson.annotations.SerializedName

data class ItemData(
    val color: String? = null,
    val capacity: String? = null,
    @SerializedName("capacity GB") val capacityGB: Int? = null,
    val price: Double? = null,
    val generation: String? = null,
    val year: Int? = null,
    @SerializedName("CPU model") val cpuModel: String? = null,
    @SerializedName("Hard disk size") val hardDiskSize: String? = null,
    @SerializedName("Strap Colour") val strapColour: String? = null,
    @SerializedName("Case Size") val caseSize: String? = null,
    @SerializedName("Description") val description: String? = null,
    @SerializedName("Screen size") val screenSize: Double? = null,
    @SerializedName("Generation") val generationAlt: String? = null,
    @SerializedName("Price") val priceAlt: String? = null
)