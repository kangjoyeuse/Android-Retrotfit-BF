package com.kangjoyeuse.submissionbfaa2.model

import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("listEvents")
    val listEvents: List<ListEventsItem> = listOf()
)

data class ListEventsItem(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("imageLogo")
    val imageLogo: String = "",
    @SerializedName("mediaCover")
    val mediaCover: String = "",
    // Anda bisa menambahkan field lain sesuai dengan respons API
    @SerializedName("dateStart")
    val dateStart: String = "",
    @SerializedName("dateFinish")
    val dateFinish: String = "",
    @SerializedName("type")
    val type: String = ""
)