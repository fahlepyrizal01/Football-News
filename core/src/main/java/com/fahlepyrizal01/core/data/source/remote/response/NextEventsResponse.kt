package com.fahlepyrizal01.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class NextEventsResponse(

    @field:SerializedName("events")
    val events: List<EventResponse>

)