package com.fahlepyrizal01.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class StandingsResponse(

    @field:SerializedName("table")
    val standing: List<StandingResponse>

)