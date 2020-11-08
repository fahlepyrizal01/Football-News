package com.fahlepyrizal01.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LeaguesResponse(

    @field:SerializedName("leagues")
    val leagues: List<LeagueResponse>

)